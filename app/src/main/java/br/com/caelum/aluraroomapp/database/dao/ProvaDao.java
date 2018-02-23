package br.com.caelum.aluraroomapp.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;

import br.com.caelum.aluraroomapp.model.Prova;

/**
 * Created by matheusbrandino on 2/23/18.
 */
@Dao
public interface ProvaDao {
    @Insert
    void salva(Prova prova);
}