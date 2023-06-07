package com.jocile.escola.entidades;

import java.util.ArrayList;
import java.util.List;

public class Disciplina {
    private String nome;
    private int semestre;
    private String horario;
    private Professor professor;
    private List<Aluno> lstAluno;

    public Disciplina(String nome, int semestre, String horario, Professor professor, List<Aluno> lstAluno) {
        this.nome = nome;
        this.semestre = semestre;
        this.horario = horario;
        this.professor = professor;
        this.lstAluno = lstAluno;
    }

    public Disciplina() {
        this.nome = "";
        this.semestre = 0;
        this.horario = "";
        this.professor = new Professor();
        this.lstAluno = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public List<Aluno> getLstAluno() {
        return lstAluno;
    }

    public void setLstAluno(List<Aluno> lstAluno) {
        this.lstAluno = lstAluno;
        // implementar adicionar aluno
        //this.lstAluno.add(Aluno) 
    }
    
    
}
