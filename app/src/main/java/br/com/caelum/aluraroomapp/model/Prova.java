package br.com.caelum.aluraroomapp.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;
import java.util.Calendar;

/**
 * Created by matheusbrandino on 2/22/18.
 */

@Entity
public class Prova implements Serializable {

    @PrimaryKey
    private Long id;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return materia;
    }
}
