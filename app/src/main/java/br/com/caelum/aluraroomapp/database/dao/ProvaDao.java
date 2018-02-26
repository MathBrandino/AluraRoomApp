package br.com.caelum.aluraroomapp.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import br.com.caelum.aluraroomapp.model.Prova;

@Dao
public interface ProvaDao {
    @Insert
    void salva(Prova prova);

    @Query("select * from prova")
    List<Prova> lista();

    @Update
    void altera(Prova prova);

    @Delete
    void deleta(Prova provaSelecionada);
}
