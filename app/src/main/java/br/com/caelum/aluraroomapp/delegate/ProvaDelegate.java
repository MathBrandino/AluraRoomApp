package br.com.caelum.aluraroomapp.delegate;

import android.support.annotation.NonNull;

import br.com.caelum.aluraroomapp.model.Prova;


public interface ProvaDelegate {

    void alteraNomeActionBar(@NonNull String nomeASerExibido);

    void lidaComClickDoFAB();

    void retornaParaTelaAnterior();

    void lidaCom(Prova provaSelecionada);
}
