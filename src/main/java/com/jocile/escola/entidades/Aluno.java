package com.jocile.escola.entidades;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    /*Método que para prencher o aluno com: nome;sexo;idade;matricula;ano;
    * @param linhaLida String - usa a linha lida do arquivo
    */
    public void fill(String linhaLida) {
        String []vet = linhaLida.split(";");
        
        this.nome = vet[0];
        this.sexo = vet[1].charAt(0);
        this.idade = Integer.parseInt(vet[2]);
        this.matricula = vet[3];
        SimpleDateFormat anoF = new SimpleDateFormat("yyyy");
        this.anoDeIngresso = new Date();
        
        try {
            Date ano;
            ano = anoF.parse(vet[4]);
            this.anoDeIngresso = ano;
        } catch (ParseException ex) {
            Logger.getLogger(Aluno.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public String cabecalho(){
        return "nome;sexo;idade;matricula;ano;\n";
    }
    
    public String atributosCSV(){
        return this.nome + ";"
        + this.sexo  + ";"
        + this.idade  + ";"
        + this.matricula  + ";"
        + this.anoDeIngresso  + ";\n";
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

    @Override
    public String toString() {
        return ("__________________________\n"
                + "Nome: " + this.nome + "\n"
                + "Sexo:" + this.sexo + "\n"
                + "Idade: " + this.idade + "\n"
                + "Matricula: " + this.matricula + "\n"
                + "__________________________\n");
    }
}
