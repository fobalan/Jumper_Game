package jumper.flavio.com.br.jumper.graphic;

import android.graphics.Paint;
import android.graphics.Typeface;

/**
 * Created by Flavio on 02/08/2017.
 */

public class Cores {

    public static Paint getCorDoPassaro() {
        Paint corDoPassaro = new Paint();
        corDoPassaro.setColor(0xFFFF0000);
        return corDoPassaro;
    }

    public static Paint getCorDoCano() {
        Paint corDoCano = new Paint();
        corDoCano.setColor(0xFF00FF00);
        return corDoCano;
    }

    public static Paint getCorDaPontuacao() {
        Paint corDaPontuacao = new Paint();
        corDaPontuacao.setColor(0xFFFFFFFF);
        corDaPontuacao.setTextSize(80);
        corDaPontuacao.setShadowLayer(3,5,5,0xFF000000);
        return corDaPontuacao;
    }

    public static Paint getCorGameOver() {
        Paint corGameOver = new Paint();
        corGameOver.setColor(0xFFFF0000);
        corGameOver.setTextSize(100);
        corGameOver.setTypeface(Typeface.DEFAULT_BOLD);
        corGameOver.setShadowLayer(2,3,3,0xFF000000);
        return corGameOver;
    }
}
