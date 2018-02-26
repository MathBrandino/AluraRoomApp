package br.com.caelum.aluraroomapp.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import br.com.caelum.aluraroomapp.R;
import br.com.caelum.aluraroomapp.converter.Conversores;
import br.com.caelum.aluraroomapp.database.GeradorDeBancoDeDados;
import br.com.caelum.aluraroomapp.database.dao.ProvaDao;
import br.com.caelum.aluraroomapp.delegate.ProvaDelegate;
import br.com.caelum.aluraroomapp.model.Prova;


public class FormularioProvasFragment extends Fragment {

    public static final String PROVA = "prova";
    public static final String TITULO_DA_ACTIVITY = "Adicionar prova";
    private ProvaDelegate delegate;
    private Prova prova = new Prova();

    private EditText materia;
    private EditText dataRealizacao;
    private Button cadastra;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        delegate = (ProvaDelegate) getActivity();
        delegate.alteraNomeActionBar(TITULO_DA_ACTIVITY);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_formulario_provas, container, false);

        buscaCamposDa(view);

        populaCamposSeNecessario();

        listenerParaBotaoCadastrar();

        return view;
    }

    private void listenerParaBotaoCadastrar() {

        cadastra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                atualizaInformacoesDaProva();

                ProvaDao provaDao = GeradorDeBancoDeDados.para(getContext()).getProvaDao();

                if (prova.getId() == null) {

                    provaDao.salva(prova);
                } else {
                    provaDao.altera(prova);
                }

                delegate.retornaParaTelaAnterior();
            }
        });
    }

    private void atualizaInformacoesDaProva() {
        prova.setMateria(materia.getText().toString());
        prova.setDataDeRealizacao(Conversores.toCalendar(dataRealizacao.getText().toString()));
    }

    private void populaCamposSeNecessario() {
        Bundle argumentos = getArguments();
        if (argumentos != null) {
            this.prova = (Prova) argumentos.get(PROVA);

            materia.setText(prova.getMateria());
            dataRealizacao.setText(Conversores.toString(prova.getDataDeRealizacao()));
        }
    }

    private void buscaCamposDa(View view) {
        materia = view.findViewById(R.id.formulario_prova_materia);
        dataRealizacao = view.findViewById(R.id.formulario_prova_data);
        cadastra = view.findViewById(R.id.formulario_prova_cadastrar);
    }

    public static Fragment com(Prova provaSelecionada) {

        Bundle argumentos = new Bundle();
        argumentos.putSerializable(PROVA, provaSelecionada);

        FormularioProvasFragment formulario = new FormularioProvasFragment();
        formulario.setArguments(argumentos);

        return formulario;

    }
}
