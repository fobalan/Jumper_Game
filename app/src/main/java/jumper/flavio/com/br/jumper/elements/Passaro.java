package jumper.flavio.com.br.jumper.elements;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import jumper.flavio.com.br.jumper.R;
import jumper.flavio.com.br.jumper.engine.Som;
import jumper.flavio.com.br.jumper.graphic.Cores;
import jumper.flavio.com.br.jumper.graphic.Tela;

/**
 * Created by Flavio on 02/08/2017.
 */

public class Passaro {

    private static final int X = 500;
    private static final Paint CORDOPASSARO = Cores.getCorDoPassaro();
    private static final int RAIO = 50;
    private static final int ALTURAPULO = 250;
    private int altura;
    private Tela tela;
    private static final int VELOCIDADEQUEDA = 5;
    private Bitmap passaro;
    private Som som;

    public Passaro (Tela tela, Context context, Som som){
        this.tela = tela;
        altura = 100;
        Bitmap bp = BitmapFactory.decodeResource(context.getResources(), R.drawable.passaro);
        passaro = bp.createScaledBitmap(bp, RAIO*2, RAIO*2, false);
        this.som = som;
    }
    public void desenhaNo(Canvas canvas) {
        //canvas.drawCircle(X,altura,RAIO,CORDOPASSARO);
        canvas.drawBitmap(passaro, X - RAIO, altura - RAIO, null);
    }

    public void cai() {
        boolean chegouNoChao = altura + RAIO >= tela.getAltura();

        if (!chegouNoChao) {
            this.altura += VELOCIDADEQUEDA;
        }
    }

    public void pula() {
        if( altura - RAIO > 0) {
            som.toca(Som.PULO);
            this.altura -= ALTURAPULO;
        }
    }

    public int getCentro() {
        return X;
    }

    public int getRaio() {
        return RAIO;
    }

    public int getAltura() {
        return altura;
    }
}
