package com.jocile.escola.entidades;

public class Aluno {

    private String nome;
    private char sexo;
    private int idade;
    private String matricula;
    private int anoDeIngresso;

    public Aluno(String nome, char sexo, int idade, String matricula, int anoDeIngresso) {
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
        this.anoDeIngresso = 0;
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
        this.anoDeIngresso = Integer.parseInt(vet[4]);
        
    }
    
    /** Retorna o cabeçalho para o arquivo txt     * 
     * @return String
     */
    public String cabecalho(){
        return "nome;sexo;idade;matricula;ano;\n";
    }
    
    /** Retorna uma linha preenchida com os atributos do aluno
     * 
     * @return String
     */
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

    public int getAnoDeIngresso() {
        return anoDeIngresso;
    }

    public void setAnoDeIngresso(int anoDeIngresso) {
        this.anoDeIngresso = anoDeIngresso;
    }
    
    @Override
    public boolean equals(Object obj){
        Aluno outro = (Aluno) obj;
        if(!super.equals(obj))
            return false;       
        else if(this.matricula.equals(outro.getMatricula()))
            return false;
        
        return true;
    }

    @Override
    public String toString() {
        return ("__________________________\n"
                + "Nome: " + this.nome + "\n"
                + "Sexo:" + this.sexo + "\n"
                + "Idade: " + this.idade + "\n"
                + "Matricula: " + this.matricula + "\n"
                + "Ano de ingresso: " + this.anoDeIngresso + "\n"
                + "__________________________\n");
    }
}
