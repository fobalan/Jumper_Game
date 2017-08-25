package jumper.flavio.com.br.jumper.elements;

import android.graphics.Canvas;

import jumper.flavio.com.br.jumper.graphic.Cores;
import jumper.flavio.com.br.jumper.graphic.Tela;

/**
 * Created by Flavio on 10/08/2017.
 */

public class ClickInicio {
    public void desenhaNo(Canvas canvas, Tela tela) {
        canvas.drawText("Clique para iniciar", 100, tela.getAltura()/2, Cores.getCorGameOver());
    }
}
