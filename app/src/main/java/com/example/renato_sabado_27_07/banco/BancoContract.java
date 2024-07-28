package com.example.renato_sabado_27_07.banco;

import android.provider.BaseColumns;

public final class BancoContract implements BaseColumns {
    private BancoContract() {} // para garantir que não terá instancias

    public static class AlunoTable implements BaseColumns {
        public static final String TABLE_NAME = "aluno";
        public static final String COLUMN_NOME = "nome";
    }

    public static class DisciplinaTable implements BaseColumns {
        public static final String TABLE_NAME = "disciplina";
        public static final String COLUMN_NOME = "nome";
        public static final String COLUNN_ALUNO_ID = "aluno_id";
    }
}
