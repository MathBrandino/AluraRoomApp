package br.com.caelum.aluraroomapp.model;

import java.io.Serializable;
import java.util.Calendar;

/**
 * Created by matheusbrandino on 2/22/18.
 */

public class Prova implements Serializable {

    private String materia;
    private Calendar dataDeRealizacao;

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public Calendar getDataDeRealizacao() {
        return dataDeRealizacao;
    }

    public void setDataDeRealizacao(Calendar dataDeRealizacao) {
        this.dataDeRealizacao = dataDeRealizacao;
    }

    @Override
    public String toString() {
        return materia;
    }
}
