package jumper.flavio.com.br.jumper.elements;

import android.graphics.Canvas;

import jumper.flavio.com.br.jumper.graphic.Cores;
import jumper.flavio.com.br.jumper.graphic.Tela;

/**
 * Created by Flavio on 05/08/2017.
 */

public class GameOver {

    public void desenhaNo(Canvas canvas, Tela tela) {
        canvas.drawText("Game Over", 300, tela.getAltura()/2, Cores.getCorGameOver());
    }
}
