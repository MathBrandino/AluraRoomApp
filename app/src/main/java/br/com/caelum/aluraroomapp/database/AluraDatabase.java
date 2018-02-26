package br.com.caelum.aluraroomapp.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import br.com.caelum.aluraroomapp.converter.Conversores;
import br.com.caelum.aluraroomapp.database.dao.AlunoDao;
import br.com.caelum.aluraroomapp.database.dao.ProvaDao;
import br.com.caelum.aluraroomapp.model.Aluno;
import br.com.caelum.aluraroomapp.model.Prova;



@Database(version = 2, entities = {Aluno.class, Prova.class})
@TypeConverters({Conversores.class})
public abstract class AluraDatabase extends RoomDatabase {

    public abstract AlunoDao getAlunoDao();

    public abstract ProvaDao getProvaDao();

}
