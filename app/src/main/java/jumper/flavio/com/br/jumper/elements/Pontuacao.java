package jumper.flavio.com.br.jumper.elements;

import android.graphics.Canvas;
import android.graphics.Paint;

import jumper.flavio.com.br.jumper.engine.Som;
import jumper.flavio.com.br.jumper.graphic.Cores;

/**
 * Created by Flavio on 04/08/2017.
 */

public class Pontuacao {
    private int pontos = 0;
    private Paint corDaPontuacao = Cores.getCorDaPontuacao();
    private Som som;
    public Pontuacao(Som som){
        this.som = som;
    }
    public void desenhaNo(Canvas canvas) {
        canvas.drawText(String.valueOf(pontos),500,100,corDaPontuacao);
    }

    public void aumenta() {
        som.toca(Som.PONTOS);
        pontos++;
    }
}
