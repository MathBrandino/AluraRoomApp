package br.com.caelum.aluraroomapp.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import br.com.caelum.aluraroomapp.model.Aluno;

/**
 * Created by matheusbrandino on 2/22/18.
 */

@Dao
public interface AlunoDao {

    @Insert
    void insere(Aluno aluno);

    @Update
    void atualiza(Aluno aluno);

    @Query("select * from Aluno order by nome")
    List<Aluno> lista();

    @Delete
    void deleta(Aluno aluno);
}
