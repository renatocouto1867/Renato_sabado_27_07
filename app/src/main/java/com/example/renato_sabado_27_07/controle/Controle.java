package com.example.renato_sabado_27_07.controle;

import android.database.sqlite.SQLiteDatabase;

import com.example.renato_sabado_27_07.Disciplina;
import com.example.renato_sabado_27_07.Estudante;
import com.example.renato_sabado_27_07.dao.DisciplinaDAO;
import com.example.renato_sabado_27_07.dao.EstudanteDAO;

import java.util.ArrayList;
import java.util.List;

public class Controle {
    private EstudanteDAO estudanteDAO;
    private DisciplinaDAO disciplinaDAO;
    private SQLiteDatabase db;

    public Controle(SQLiteDatabase db) {
        this.db = db;
        this.estudanteDAO = new EstudanteDAO(db);
        this.disciplinaDAO = new DisciplinaDAO(db);
    }

    public List<Long> adicionarAluno() { // vai ter que ser remodelada
    Estudante aluno;
    List<Long> ids = new ArrayList<>();
    aluno = new Estudante("Ana");

    long alunoId = estudanteDAO.adcionarAluno(aluno);
    ids.add(alunoId);
    aluno = new Estudante("Rodrigo");
    alunoId = estudanteDAO.adcionarAluno(aluno);
    ids.add(alunoId);
    return ids;
    }

    public String consultarAlunos() {
        List<Estudante> alunos = estudanteDAO.obterTodosAlunos();
        return alunos.toString();
    }

    public List<Long> adicionarDisciplina() { // tera que ajustar, para view
        Disciplina disciplina;

        List<Long> ids = new ArrayList<>();
        List<Estudante> alunos = estudanteDAO.obterTodosAlunos();

        disciplina = new Disciplina("MAT101", alunos.get(0));
        long disciplinaId = disciplinaDAO.adicionarDisciplina(disciplina);
        ids.add(disciplinaId);

        disciplina = new Disciplina("BIO101", alunos.get(0));
        disciplinaId = disciplinaDAO.adicionarDisciplina(disciplina);
        ids.add(disciplinaId);

        return ids;
    }

    public String consultarDisciplinasPorAluno() { // tera que ajustar
        List<Estudante> alunos = estudanteDAO.obterTodosAlunos();
        List<Disciplina> disciplinas = disciplinaDAO.listarDisciplinas(alunos.get(0));
        return disciplinas.toString();
    }

}//Controle
