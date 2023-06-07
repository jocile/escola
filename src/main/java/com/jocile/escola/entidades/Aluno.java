package com.jocile.escola.entidades;

import java.util.Date;

public class Aluno {
  private String nome;
  private char sexo;
  private int idade;
  private String matricula;
  private Date anoDeIngresso;

    public Aluno(String nome, char sexo, int idade, String matricula, Date anoDeIngresso) {
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
        this.matricula = matricula;
        this.anoDeIngresso = anoDeIngresso;
    }

    public Aluno() {
        this.nome = "";
        this.sexo = 'f';
        this.idade = 0;
        this.matricula = "";
        this.anoDeIngresso = new Date();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Date getAnoDeIngresso() {
        return anoDeIngresso;
    }

    public void setAnoDeIngresso(Date anoDeIngresso) {
        this.anoDeIngresso = anoDeIngresso;
    }

    
}
