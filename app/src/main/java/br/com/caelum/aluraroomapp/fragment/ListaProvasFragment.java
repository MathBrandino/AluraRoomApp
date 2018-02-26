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
import br.com.caelum.aluraroomapp.database.dao.ProvaDao;
import br.com.caelum.aluraroomapp.delegate.ProvaDelegate;
import br.com.caelum.aluraroomapp.model.Prova;


public class ListaProvasFragment extends Fragment {

    public static final String TITULO_DA_ACTIVITY = "Provas realizadas";
    private ProvaDelegate delegate;
    private ListView listaDeProvas;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        delegate = (ProvaDelegate) getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lista, container, false);

        configuraCampos(view);

        return view;
    }

    private void configuraCampos(View view) {

        listaDeProvas = view.findViewById(R.id.fragment_lista);

        listaDeProvas.setOnItemClickListener(clickNaLista());

        listaDeProvas.setOnItemLongClickListener(clickLongoNaLista());


        FloatingActionButton botaoAdicionar = view.findViewById(R.id.fragment_lista_fab);
        listenerPara(botaoAdicionar);
    }

    private AdapterView.OnItemLongClickListener clickLongoNaLista() {
        return new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int posicao, long id) {
                Prova provaSelecionada = (Prova) adapterView.getItemAtPosition(posicao);

                removeProva(provaSelecionada);

                carregaLista();

                return true;
            }
        };
    }

    private void removeProva(Prova provaSelecionada) {
        ProvaDao provaDao = GeradorDeBancoDeDados.para(getContext()).getProvaDao();

        provaDao.deleta(provaSelecionada);
    }

    private AdapterView.OnItemClickListener clickNaLista() {
        return new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicao, long id) {
                Prova provaSelecionada = (Prova) adapterView.getItemAtPosition(posicao);

                delegate.lidaCom(provaSelecionada);
            }
        };
    }

    private void listenerPara(FloatingActionButton botaoFlutuante) {
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
        delegate.alteraNomeActionBar(TITULO_DA_ACTIVITY);


        carregaLista();
    }

    private void carregaLista() {

        Context contexto = getContext();

        ProvaDao provaDao = GeradorDeBancoDeDados.para(contexto).getProvaDao();
        List<Prova> provas = provaDao.lista();

        listaDeProvas.setAdapter(new ArrayAdapter<Prova>(contexto, android.R.layout.simple_list_item_1, provas));
    }
}
