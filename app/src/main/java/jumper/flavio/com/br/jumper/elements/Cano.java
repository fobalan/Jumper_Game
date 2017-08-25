package jumper.flavio.com.br.jumper.elements;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import jumper.flavio.com.br.jumper.R;
import jumper.flavio.com.br.jumper.graphic.Cores;
import jumper.flavio.com.br.jumper.graphic.Tela;

/**
 * Created by Flavio on 02/08/2017.
 */

public class Cano {
    private Tela tela;
    private int posicao;
    private int largura = 200;
    private int altura = 100;
    private Paint corCano = Cores.getCorDoCano();
    private int alturaCanoInferior = 0;
    private int alturaCanoSuperior = 0;
    private boolean passouDoPassaroUmaVez = false;
    private int distanciaEntreSuperiorEInferior = 400;
    private Bitmap canoInferior;
    private Bitmap canoSuperior;

    private int valorAleatorio() {
        return (int) (Math.random() * 500);
    }

    public Cano(Tela tela, int posicaoInicial, Context context){
        this.tela = tela;
        this.posicao = posicaoInicial;
        this.alturaCanoSuperior = altura + valorAleatorio();
        this.alturaCanoInferior = this.alturaCanoSuperior + distanciaEntreSuperiorEInferior;
        int comprimentoCanoSuperior = this.alturaCanoSuperior;
        int comprimentoCanoInferior = tela.getAltura() - this.alturaCanoInferior;
        Bitmap bp = BitmapFactory.decodeResource(context.getResources(), R.drawable.cano);
        canoInferior = Bitmap.createScaledBitmap(bp, largura, comprimentoCanoInferior, false);
        canoSuperior = Bitmap.createScaledBitmap(bp, largura, comprimentoCanoSuperior, false);

    }
    public void desenhaNo(Canvas canvas) {
        desenhaCanoInferiorNo(canvas);
        desenhaCanoSuperiorNo(canvas);
    }

    private void desenhaCanoSuperiorNo(Canvas canvas) {
        //canvas.drawRect(posicao, 0, posicao + largura, alturaCanoSuperior,corCano);
        canvas.drawBitmap(canoSuperior, posicao, 0, null);
    }

    private void desenhaCanoInferiorNo(Canvas canvas) {
        //
        // canvas.drawRect(posicao, alturaCanoInferior, posicao + largura, tela.getAltura(),corCano);
        canvas.drawBitmap(canoInferior, posicao, alturaCanoInferior, null);
    }

    public void move() {
        posicao -= 5;
    }

    public boolean saiuDaTela() {
        return posicao + largura < 0 ;
    }

    public int getPosicao() {
        return posicao;
    }

    public boolean passouDo(Passaro passaro) {
            if(posicao + largura < passaro.getCentro() - passaro.getRaio()){
                passouDoPassaroUmaVez = true;
                return true;
            } else {
                return false;
            }
    }

    public boolean getPassouDoPassaroUmaVez(){
        return passouDoPassaroUmaVez;
    }

    public boolean temColisaoHorizontalCom(Passaro passaro) {
        return posicao < passaro.getCentro() + passaro.getRaio()
                && posicao + largura > passaro.getCentro() - passaro.getRaio();
    }

    public boolean temColisaoVerticalCom(Passaro passaro) {
        return passaro.getAltura() - passaro.getRaio() < alturaCanoSuperior
                || passaro.getAltura() + passaro.getRaio() > alturaCanoInferior;
    }
}
