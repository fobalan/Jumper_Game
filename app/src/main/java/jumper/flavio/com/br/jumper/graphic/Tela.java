package jumper.flavio.com.br.jumper.graphic;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

/**
 * Created by Flavio on 02/08/2017.
 */

public class Tela {

    private DisplayMetrics metrics;

    public Tela (Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(context.WINDOW_SERVICE);
        Display defaultDisplay = wm.getDefaultDisplay();
        metrics = new DisplayMetrics();
        defaultDisplay.getMetrics(metrics);
    }

    public int getAltura(){
        return metrics.heightPixels;
    }

    public int getLargura(){
        return metrics.widthPixels;
    }
}
