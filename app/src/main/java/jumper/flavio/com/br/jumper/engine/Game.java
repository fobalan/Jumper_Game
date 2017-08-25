package jumper.flavio.com.br.jumper.engine;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import jumper.flavio.com.br.jumper.R;
import jumper.flavio.com.br.jumper.elements.Canos;
import jumper.flavio.com.br.jumper.elements.ClickInicio;
import jumper.flavio.com.br.jumper.elements.GameOver;
import jumper.flavio.com.br.jumper.elements.Passaro;
import jumper.flavio.com.br.jumper.elements.Pontuacao;
import jumper.flavio.com.br.jumper.graphic.Tela;

/**
 * Created by Flavio on 01/08/2017.
 */

public class Game extends SurfaceView implements Runnable, View.OnTouchListener {

    private boolean isRunning = true;
    private SurfaceHolder holder = getHolder();
    private Passaro passaro;
    private Bitmap background;
    private Tela tela;
    private Canos canos;
    private Pontuacao pontuacao;
    private Context context;
    private Som som;
    private boolean iniciouJogo = false;

    public Game(Context context) {
        super(context);

        tela = new Tela(context);
        this.context = context;
        this.som = new Som(context);

        inicializaElementos(context);

        setOnTouchListener(this);

    }

    private void inicializaElementos(Context context) {
        passaro = new Passaro(tela, context,som);
        pontuacao = new Pontuacao(som);
        canos = new Canos(tela, pontuacao, passaro, context,som);
        Bitmap back = BitmapFactory.decodeResource(getResources(), R.drawable.background);
        background = Bitmap.createScaledBitmap(back, tela.getLargura(), tela.getAltura(), false);
    }

    @Override
    public void run() {
        while (isRunning){
            //desenho do Jogo
            if(!holder.getSurface().isValid()) continue;

            Canvas canvas = holder.lockCanvas();
            canvas.drawBitmap(background, 0, 0, null);

            //desenha componentes do Jogo
            passaro.desenhaNo(canvas);
            if(!iniciouJogo){
                ClickInicio clickInicio = new ClickInicio();
                clickInicio.desenhaNo(canvas,tela);
                holder.unlockCanvasAndPost(canvas);
                continue;
            }

            passaro.cai();

            canos.desenhaNo(canvas);
            canos.move();

            pontuacao.desenhaNo(canvas);

            if(new VerificacaoDeColisao(passaro,canos).temColisao()){
                GameOver gameover = new GameOver();
                gameover.desenhaNo(canvas,tela);
                isRunning = false;
            }
            holder.unlockCanvasAndPost(canvas);
        }
    }

    public void inicia() {
        isRunning = true;
    }

    public void pausa() {
        isRunning = false;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        passaro.pula();
        iniciouJogo = true;
        return false;
    }
}
