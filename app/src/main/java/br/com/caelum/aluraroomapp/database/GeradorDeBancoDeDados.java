package br.com.caelum.aluraroomapp.database;

import android.arch.persistence.room.Room;
import android.content.Context;

import br.com.caelum.aluraroomapp.database.dao.AlunoDao;

/**
 * Created by matheusbrandino on 2/22/18.
 */

public class GeradorDeBancoDeDados {

    private static AluraDatabase aluradb;

    public static AluraDatabase para(Context contexto) {
        aluradb = Room.databaseBuilder(contexto, AluraDatabase.class, "aluradb").allowMainThreadQueries().build();
        return aluradb;
    }

    public AlunoDao getAlunoDao() {
        return aluradb.getAlunoDao();
    }

}
