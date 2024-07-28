package com.example.renato_sabado_27_07.banco;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BancoHelper extends SQLiteOpenHelper {
    private static final String NOME_BANCO = "escola.db";
    private static final int VERSAO_BANCO = 1;

    public BancoHelper(@Nullable Context context) {
        super(context, NOME_BANCO, null, VERSAO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_ALUNO_TABLE = "CREATE TABLE " + BancoContract.AlunoTable.TABLE_NAME + " ("
                + BancoContract.AlunoTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + BancoContract.AlunoTable.COLUMN_NOME + " TEXT)";
        db.execSQL(CREATE_ALUNO_TABLE);

        String CREATE_DISCIPLINA_TABLE = "CREATE TABLE " + BancoContract.DisciplinaTable.TABLE_NAME + " ("
                + BancoContract.DisciplinaTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + BancoContract.DisciplinaTable.COLUMN_NOME + " TEXT, "
                + BancoContract.DisciplinaTable.COLUNN_ALUNO_ID + " INTEGER, "
                + "FOREIGN KEY (" + BancoContract.DisciplinaTable.COLUNN_ALUNO_ID + ") REFERENCES "
                + BancoContract.AlunoTable.TABLE_NAME + "(" + BancoContract.AlunoTable._ID + "))";
            db.execSQL(CREATE_DISCIPLINA_TABLE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + BancoContract.AlunoTable.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + BancoContract.DisciplinaTable.TABLE_NAME);
        onCreate(db);

    }
}
