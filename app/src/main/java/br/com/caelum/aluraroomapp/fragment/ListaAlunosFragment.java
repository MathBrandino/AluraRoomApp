package br.com.caelum.aluraroomapp.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import br.com.caelum.aluraroomapp.R;
import br.com.caelum.aluraroomapp.delegate.AlunoDelegate;

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

        listagem = view.findViewById(R.id.fragment_lista);
        FloatingActionButton botaoFlutuante = view.findViewById(R.id.fragment_lista_fab);

        botaoFlutuante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                delegate.lidaComClickDoFAB();
            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        delegate.alteraNomeActionBar("Listagem de alunos");

    }
}
