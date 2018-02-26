package br.com.caelum.aluraroomapp.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import br.com.caelum.aluraroomapp.R;
import br.com.caelum.aluraroomapp.delegate.ProvaDelegate;
import br.com.caelum.aluraroomapp.fragment.FormularioProvasFragment;
import br.com.caelum.aluraroomapp.fragment.ListaProvasFragment;
import br.com.caelum.aluraroomapp.model.Prova;


public class ProvasActivity extends AppCompatActivity implements ProvaDelegate {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provas);

        adicionaBotaoVoltar();

        exibe(new ListaProvasFragment(), false);
    }


    private void exibe(Fragment fragment, boolean adicionadoNaPilha) {

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.replace(R.id.provas_frame, fragment);
        if (adicionadoNaPilha)
            transaction.addToBackStack(null);

        transaction.commit();
    }


    private void adicionaBotaoVoltar() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void alteraNomeActionBar(@NonNull String nomeASerExibido) {
        getSupportActionBar().setTitle(nomeASerExibido);
    }

    @Override
    public void lidaComClickDoFAB() {
        exibe(new FormularioProvasFragment(), true);
    }

    @Override
    public void retornaParaTelaAnterior() {

        onBackPressed();
    }

    @Override
    public void lidaCom(Prova provaSelecionada) {
        exibe(FormularioProvasFragment.com(provaSelecionada), true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            retornaParaTelaAnterior();
        }

        return true;
    }
}
