package br.com.caelum.aluraroomapp.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import br.com.caelum.aluraroomapp.converter.Conversores;
import br.com.caelum.aluraroomapp.database.dao.AlunoDao;
import br.com.caelum.aluraroomapp.model.Aluno;

/**
 * Created by matheusbrandino on 2/22/18.
 */

@Database(version = 1, entities = {Aluno.class})
@TypeConverters({Conversores.class})
public abstract class AluraDatabase extends RoomDatabase {

    public abstract AlunoDao getAlunoDao();

}
