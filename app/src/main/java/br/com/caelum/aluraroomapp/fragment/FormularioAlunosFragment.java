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
import br.com.caelum.aluraroomapp.database.dao.AlunoDao;
import br.com.caelum.aluraroomapp.delegate.AlunoDelegate;
import br.com.caelum.aluraroomapp.model.Aluno;



public class FormularioAlunosFragment extends Fragment {

    public static final String ALUNO = "aluno";
    public static final String TITULO_DA_ACTIVITY = "Cadastrar novo aluno";
    private Aluno aluno = new Aluno();

    private EditText nome;
    private EditText dataNascimento;
    private EditText email;
    private Button cadastrar;
    private AlunoDelegate delegate;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        delegate = (AlunoDelegate) getActivity();
        delegate.alteraNomeActionBar(TITULO_DA_ACTIVITY);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_formulario_alunos, container, false);

        buscaCamposDa(view);

        populaCamposQuandoNecessario();

        listenerBotaoCadastrar();

        return view;
    }

    private void listenerBotaoCadastrar() {

        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                atualizaInformacoesDoAluno();

                AlunoDao alunoDao = GeradorDeBancoDeDados.para(getContext()).getAlunoDao();

                if (aluno.getId() == null) {
                    alunoDao.insere(aluno);

                } else {
                    alunoDao.atualiza(aluno);
                }

                delegate.retornaParaTelaAnterior();
            }
        });

    }

    private void populaCamposQuandoNecessario() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.aluno = (Aluno) arguments.get(ALUNO);

            nome.setText(aluno.getNome());
            email.setText(aluno.getEmail());
            dataNascimento.setText(Conversores.toString(aluno.getDataNascimento()));
        }
    }

    private void buscaCamposDa(View view) {
        nome = view.findViewById(R.id.formulario_alunos_nome);
        dataNascimento = view.findViewById(R.id.formulario_alunos_nascimento);
        email = view.findViewById(R.id.formulario_alunos_email);
        cadastrar = view.findViewById(R.id.formulario_alunos_cadastrar);
    }


    private void atualizaInformacoesDoAluno() {
        aluno.setNome(nome.getText().toString());
        aluno.setEmail(email.getText().toString());
        aluno.setDataNascimento(Conversores.toCalendar(dataNascimento.getText().toString()));
    }

    public static Fragment com(Aluno aluno) {
        Bundle argumentos = new Bundle();

        argumentos.putSerializable(ALUNO, aluno);

        FormularioAlunosFragment formulario = new FormularioAlunosFragment();

        formulario.setArguments(argumentos);

        return formulario;

    }
}
