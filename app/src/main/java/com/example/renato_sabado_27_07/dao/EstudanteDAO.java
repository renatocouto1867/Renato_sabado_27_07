package com.example.renato_sabado_27_07.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.renato_sabado_27_07.Estudante;
import com.example.renato_sabado_27_07.banco.BancoContract;

import java.util.ArrayList;
import java.util.List;

public class EstudanteDAO {
    private SQLiteDatabase db;

    public EstudanteDAO(SQLiteDatabase db) {
        this.db = db;
    }

    public long adcionarAluno(Estudante estudante) {
        ContentValues values = new ContentValues();
        values.put(BancoContract.AlunoTable.COLUMN_NOME, estudante.getNome());
        return db.insert(BancoContract.AlunoTable.TABLE_NAME, null, values);
    }

    public List<Estudante> obterTodosAlunos() {
        List<Estudante> listaAlunos = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + BancoContract.AlunoTable.TABLE_NAME;
        Cursor cursor = db.rawQuery(selectQuery, null);

        while (cursor.moveToNext()) {
            Estudante aluno = new Estudante();
            aluno.setId(cursor.getLong(cursor.getColumnIndexOrThrow(BancoContract.AlunoTable._ID)));
            aluno.setNome(cursor.getString(cursor.getColumnIndexOrThrow(BancoContract.AlunoTable.COLUMN_NOME)));
//            aluno.setDisciplinas(obterDisciplinasPorAluno(aluno.getId()));
            listaAlunos.add(aluno);
        }

        cursor.close();
        return listaAlunos;

    }
}
