package br.com.caelum.aluraroomapp.database;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.migration.Migration;
import android.content.Context;
import android.support.annotation.NonNull;


public class GeradorDeBancoDeDados {

    public static final String ALURA_DB = "aluradb";
    private static AluraDatabase aluradb;

    public static AluraDatabase para(Context contexto) {
        aluradb = Room.databaseBuilder(contexto, AluraDatabase.class, ALURA_DB)
                .allowMainThreadQueries()
                .addMigrations(umParaDois())    // poderia usar o metodo fallbackToDestructiveMigration() senão precisar manter
                .build();
        return aluradb;
    }

    private static Migration umParaDois() {

        return new Migration(1, 2) {
            @Override
            public void migrate(@NonNull SupportSQLiteDatabase database) {

                String sql = "create table Prova( id integer primary key, materia text, dataDeRealizacao text)";
                database.execSQL(sql);

            }
        };
    }

}
