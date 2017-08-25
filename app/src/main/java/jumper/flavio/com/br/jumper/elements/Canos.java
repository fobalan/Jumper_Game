package jumper.flavio.com.br.jumper.elements;

import android.content.Context;
import android.graphics.Canvas;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import jumper.flavio.com.br.jumper.engine.Som;
import jumper.flavio.com.br.jumper.graphic.Tela;

/**
 * Created by Flavio on 02/08/2017.
 */

public class Canos {

    private final Passaro passaro;
    private List<Cano> canos = new ArrayList();
    private static final int DISTANCIA_ENTRE_CANOS = 600;
    private static final int QUANTIDADE_DE_CANOS = 7;
    private static final int POSICAO_INICIAL = 800;
    private Tela tela;
    public Pontuacao pontuacao;
    private Context context;
    private Som som;

    public Canos(Tela tela, Pontuacao pontuacao, Passaro passaro, Context context, Som som) {
        this.pontuacao = pontuacao;
        this.passaro = passaro;
        int posicao = POSICAO_INICIAL;
        this.tela = tela;
        this.context = context;
        this.som = som;

        for (int i = 0; i < QUANTIDADE_DE_CANOS; i++) {
            posicao += DISTANCIA_ENTRE_CANOS;
            Cano cano = new Cano(tela, posicao,context);
            canos.add(cano);
        }
    }

    public void desenhaNo(Canvas canvas) {
        for (Cano cano : canos) {
            cano.desenhaNo(canvas);
        }
    }

    public void move() {
        ListIterator<Cano> interator = canos.listIterator();
        while (interator.hasNext()) {
            Cano cano = interator.next();
            cano.move();
            if (cano.saiuDaTela()) {
                interator.remove();
                Cano outroCano = new Cano(tela, getDistanciaMaxima() + DISTANCIA_ENTRE_CANOS, context);
                interator.add(outroCano);
            }
            if (!cano.getPassouDoPassaroUmaVez()) {
                if (cano.passouDo(passaro)) {
                    pontuacao.aumenta();
                }
            }
        }
    }


    public int getDistanciaMaxima() {
        int maximo = 0;
        for (Cano cano : canos) {
            maximo = Math.max(cano.getPosicao(), maximo);
        }
        return maximo;
    }

    public boolean temColisaoCom(Passaro passaro) {
        for (Cano cano : canos) {
            if (cano.temColisaoHorizontalCom(passaro)
                    && cano.temColisaoVerticalCom(passaro)) {
                som.toca(Som.COLISAO);
                return true;
            }
        }
        return false;
    }
}
