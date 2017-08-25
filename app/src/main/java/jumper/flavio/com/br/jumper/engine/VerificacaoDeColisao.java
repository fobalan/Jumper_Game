package jumper.flavio.com.br.jumper.engine;

import jumper.flavio.com.br.jumper.elements.Canos;
import jumper.flavio.com.br.jumper.elements.Passaro;

/**
 * Created by Flavio on 05/08/2017.
 */

class VerificacaoDeColisao {
    private final Canos canos;
    private final Passaro passaro;

    public VerificacaoDeColisao(Passaro passaro, Canos canos) {
        this.passaro = passaro;
        this.canos = canos;
    }

    public boolean temColisao() {
        return canos.temColisaoCom(passaro);
    }
}
