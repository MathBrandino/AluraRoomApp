package br.com.caelum.aluraroomapp.model;

import java.io.Serializable;
import java.util.Calendar;

/**
 * Created by matheusbrandino on 2/21/18.
 */

public class Aluno implements Serializable {


    private String nome;
    private String email;
    private Calendar dataNascimento;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public Calendar getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Calendar dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        return nome;
    }
}
