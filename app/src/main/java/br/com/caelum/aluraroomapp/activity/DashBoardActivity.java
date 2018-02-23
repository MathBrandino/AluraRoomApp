package br.com.caelum.aluraroomapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import br.com.caelum.aluraroomapp.R;

public class DashBoardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        Button alunos = findViewById(R.id.dash_btn_aluno);
        Button provas = findViewById(R.id.dash_btn_provas);

        alunos.setOnClickListener(vaiPara(AlunosActivity.class));
        provas.setOnClickListener(vaiPara(ProvasActivity.class));
    }

    @NonNull
    private View.OnClickListener vaiPara(final Class<?> clazz) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intencao = new Intent(DashBoardActivity.this, clazz);
                startActivity(intencao);
            }
        };
    }
}
