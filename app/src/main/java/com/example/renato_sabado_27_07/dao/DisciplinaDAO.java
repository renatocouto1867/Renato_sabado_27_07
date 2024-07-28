package com.example.renato_sabado_27_07.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.renato_sabado_27_07.Disciplina;
import com.example.renato_sabado_27_07.Estudante;
import com.example.renato_sabado_27_07.banco.BancoContract;

import java.util.ArrayList;
import java.util.List;

public class DisciplinaDAO {
    private SQLiteDatabase db;

    public DisciplinaDAO(SQLiteDatabase db) {
        this.db = db;
    }

    public long adicionarDisciplina(Disciplina disciplina) {
        ContentValues values = new ContentValues();
        values.put(BancoContract.DisciplinaTable.COLUMN_NOME, disciplina.getNome());
        values.put(BancoContract.DisciplinaTable.COLUNN_ALUNO_ID, disciplina.getAlunoId().getId());
        return db.insert(BancoContract.DisciplinaTable.TABLE_NAME, null, values);
    }

    public List<Disciplina> listarDisciplinas(Estudante estudante) {
        List<Disciplina> disciplinas = new ArrayList<>();
        String selection = BancoContract.DisciplinaTable.COLUNN_ALUNO_ID + " = ?";
        String[] selectionArgs = {String.valueOf(estudante.getId())};

        Cursor cursor = db.query(
                BancoContract.DisciplinaTable.TABLE_NAME,
                null,
                selection,
                selectionArgs,
                null,null, null);

        while (cursor.moveToNext()){
            long id = cursor.getLong(cursor.getColumnIndexOrThrow(BancoContract.DisciplinaTable._ID));
            String nome = cursor.getString(cursor.getColumnIndexOrThrow(BancoContract.DisciplinaTable.COLUMN_NOME));

//            long idAluno = cursor.getLong(cursor.getColumnIndexOrThrow(BancoContract.DisciplinaTable.COLUNN_ALUNO_ID));

            Disciplina disciplina = new Disciplina(id, nome,estudante);
            disciplinas.add(disciplina);

        }
        cursor.close();
        return disciplinas;
    }

}//DisciplinaDAO
