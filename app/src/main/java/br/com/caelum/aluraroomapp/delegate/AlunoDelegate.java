package br.com.caelum.aluraroomapp.delegate;

import android.support.annotation.NonNull;

import br.com.caelum.aluraroomapp.model.Aluno;

/**
 * Created by matheusbrandino on 2/21/18.
 */

public interface AlunoDelegate {
    void alteraNomeActionBar(@NonNull String nomeASerExibido);

    void lidaComClickDoFAB();

    void retornaParaTelaAnterior();

    void lidaComAlunoSelecionado(Aluno aluno);
}
