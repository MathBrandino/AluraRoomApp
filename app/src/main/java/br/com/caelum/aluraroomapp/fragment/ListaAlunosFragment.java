package br.com.caelum.aluraroomapp.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import br.com.caelum.aluraroomapp.R;
import br.com.caelum.aluraroomapp.database.GeradorDeBancoDeDados;
import br.com.caelum.aluraroomapp.database.dao.AlunoDao;
import br.com.caelum.aluraroomapp.delegate.AlunoDelegate;
import br.com.caelum.aluraroomapp.model.Aluno;

/**
 * Created by matheusbrandino on 2/21/18.
 */

public class ListaAlunosFragment extends Fragment {


    private AlunoDelegate delegate;
    private ListView listagem;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        delegate = (AlunoDelegate) getActivity();

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lista, container, false);

        configuraComponentes(view);

        return view;
    }

    private void configuraComponentes(View view) {
        listagem = view.findViewById(R.id.fragment_lista);

        listagem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicao, long id) {

                Aluno aluno = (Aluno) adapterView.getItemAtPosition(posicao);

                delegate.lidaComAlunoSelecionado(aluno);

            }
        });


        listenerFAB(view);
    }

    private void listenerFAB(View view) {
        FloatingActionButton botaoFlutuante = view.findViewById(R.id.fragment_lista_fab);

        botaoFlutuante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                delegate.lidaComClickDoFAB();
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        delegate.alteraNomeActionBar("Listagem de alunos");

        carregaLista();

    }

    private void carregaLista() {
        Context contexto = getContext();

        AlunoDao alunoDao = GeradorDeBancoDeDados.para(contexto).getAlunoDao();

        List<Aluno> alunos = alunoDao.lista();

        listagem.setAdapter(new ArrayAdapter<Aluno>(contexto, android.R.layout.simple_list_item_1, alunos));
    }
}

