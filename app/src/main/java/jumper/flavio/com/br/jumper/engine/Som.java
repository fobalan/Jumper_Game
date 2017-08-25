package jumper.flavio.com.br.jumper.engine;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

import jumper.flavio.com.br.jumper.R;

/**
 * Created by Flavio on 09/08/2017.
 */

public class Som {
    private SoundPool soundPool;
    public static int PULO;
    public static int COLISAO;
    public static int PONTOS;

    public Som(Context context){
        soundPool = new SoundPool(3, AudioManager.STREAM_MUSIC, 0);
        PULO = soundPool.load(context, R.raw.pulo, 1);
        COLISAO = soundPool.load(context, R.raw.colisao, 1);
        PONTOS = soundPool.load(context, R.raw.pontos, 1);

    }
    public void toca(int som){
        soundPool.play(som, 1, 1, 1, 0, 1);
    }
}
