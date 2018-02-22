package br.com.caelum.aluraroomapp.delegate;

import android.support.annotation.NonNull;

/**
 * Created by matheusbrandino on 2/21/18.
 */

public interface AlunoDelegate {
    void alteraNomeActionBar(@NonNull String nomeASerExibido);

    void lidaComClickDoFAB();

    void retornaParaTelaAnterior();
}
