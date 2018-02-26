package br.com.caelum.aluraroomapp.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import br.com.caelum.aluraroomapp.R;
import br.com.caelum.aluraroomapp.delegate.AlunoDelegate;
import br.com.caelum.aluraroomapp.fragment.FormularioAlunosFragment;
import br.com.caelum.aluraroomapp.fragment.ListaAlunosFragment;
import br.com.caelum.aluraroomapp.model.Aluno;


public class AlunosActivity extends AppCompatActivity implements AlunoDelegate {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alunos);
        adicionaBotaoVoltar();

        exibe(new ListaAlunosFragment(), false);
    }


    private void exibe(Fragment fragment, boolean adicionadoNaPilha) {

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.replace(R.id.alunos_frame, fragment);
        if (adicionadoNaPilha)
            transaction.addToBackStack(null);

        transaction.commit();
    }


    private void adicionaBotaoVoltar() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void alteraNomeActionBar(String nomeASerExibido) {
        getSupportActionBar().setTitle(nomeASerExibido);
    }

    @Override
    public void lidaComClickDoFAB() {
        exibe(new FormularioAlunosFragment(), true);
    }

    @Override
    public void retornaParaTelaAnterior() {
        onBackPressed();
    }

    @Override
    public void lidaComAlunoSelecionado(Aluno alunoSelecionado) {

        exibe(FormularioAlunosFragment.com(alunoSelecionado), true);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            retornaParaTelaAnterior();

        return true;
    }
}
