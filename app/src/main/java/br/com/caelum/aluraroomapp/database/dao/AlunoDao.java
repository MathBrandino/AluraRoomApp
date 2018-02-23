package br.com.caelum.aluraroomapp.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;

import br.com.caelum.aluraroomapp.model.Aluno;

/**
 * Created by matheusbrandino on 2/22/18.
 */

@Dao
public interface AlunoDao {

    @Insert
    void insere(Aluno aluno);
}
