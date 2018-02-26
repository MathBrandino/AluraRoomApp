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


public class ListaAlunosFragment extends Fragment {


    public static final String TITULO_DA_ACTIVITY = "Listagem de alunos";
    private AlunoDelegate delegate;
    private ListView listaDeAlunos;

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
        listaDeAlunos = view.findViewById(R.id.fragment_lista);

        listaDeAlunos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicao, long id) {

                Aluno aluno = (Aluno) adapterView.getItemAtPosition(posicao);

                delegate.lidaComAlunoSelecionado(aluno);

            }
        });

        listaDeAlunos.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int posicao, long id) {
                Aluno aluno = (Aluno) adapterView.getItemAtPosition(posicao);

                removeAluno(aluno);

                carregaLista();

                return true;
            }
        });


        listenerFAB(view);
    }

    private void removeAluno(Aluno aluno) {
        AlunoDao alunoDao = GeradorDeBancoDeDados.getAluraDatabase(getContext()).getAlunoDao();

        alunoDao.deleta(aluno);
    }

    private void listenerFAB(View view) {
        FloatingActionButton botaoAdicionar = view.findViewById(R.id.fragment_lista_fab);

        botaoAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                delegate.lidaComClickDoFAB();
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        delegate.alteraNomeActionBar(TITULO_DA_ACTIVITY);

        carregaLista();

    }

    private void carregaLista() {
        Context contexto = getContext();

        AlunoDao alunoDao = GeradorDeBancoDeDados.getAluraDatabase(contexto).getAlunoDao();

        List<Aluno> alunos = alunoDao.lista();

        listaDeAlunos.setAdapter(new ArrayAdapter<Aluno>(contexto, android.R.layout.simple_list_item_1, alunos));
    }
}

