package com.jocile.escola.dao;

import com.jocile.escola.entidades.Aluno;
import com.jocile.escola.visao.FrCadAluno;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joc
 */
public class AlunoDAO extends DAO {

    private List<Aluno> lista;

    public AlunoDAO() {
        super("Alunos.txt");
        this.lista = new ArrayList<>();
        this.loadArquivoAlunos();
    }

    /**
     * Carrega o arquivo texto na lista
     *
     */
    private void loadArquivoAlunos() {
        FileReader f = null;
        try {
            f = new FileReader("Alunos.txt");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FrCadAluno.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scanner arquivo = new Scanner(f);
        arquivo.useDelimiter("\n");//lendo a linha

        String cabecalho = arquivo.next();
        while (arquivo.hasNext()) {
            String linhaLida = arquivo.next();
            Aluno a = new Aluno();
            a.fill(linhaLida);//usa alinha para prencher o aluno com: nome;sexo;idade;matricula;ano;
            this.lista.add(a);
        }
        arquivo.close();

    }

    /**
     * Salva o aluno na lista
     *
     * @param a Aluno
     * @return verdadeiro se confirmado
     */
    protected boolean save(Aluno a) {
        this.lista.add(a);

        //Criar texto CSV
        String txt = this.listaDeAlunosCSV();
        super.save(txt);
        return true;
    }

    /**
     * Concatena a lista de alunos em um texto
     *
     *
     * @return Texto com a lista de alunos
     */
    public String listaDeAlunosCSV() {
        String txt = "";
        Aluno aluno = new Aluno();
        aluno.cabecalho();
        for (int i = 0; i <= this.lista.size() - 1; i++) {
            Aluno a = this.lista.get(i);
            txt = txt + a.atributosCSV();
        }
        return txt;
    }
    
    public String mostrarLista() {
        String listaCompleta = "";

        for (int i = 0; i <= lista.size() - 1; i++) {
            Aluno aux = lista.get(i);
            listaCompleta = listaCompleta + aux.toString();
        }
        return listaCompleta;
    }

    /**
     * Procura pelo aluno na lista
     *
     * @param aluno
     * @return aluno se encontrado na lista
     */
    public Aluno find(Aluno aluno) {
        for (Aluno a : this.lista) {
            if (a.equals(aluno)) {
                return aluno;
            }
        }
        return null;
    }

    /**
     * Procura o aluno na lista pela matrícula
     *
     * @param matriculaProcurada
     * @return Aluno se encontrada a matricula na lista
     */
    public Aluno findByMatricula(String matriculaProcurada) {
        for (Aluno a : this.lista) {
            if (a.getMatricula().equals(matriculaProcurada)) {
                return a;
            }
        }
        return null;
    }

    /**
     * Deleta o aluno da lista Downcasting de Object para Aluno
     *
     * @param obj Aluno
     * @return verdadeiro como confirmação
     */
    @Override
    public boolean delete(Object obj) {
        Aluno aluno = (Aluno) obj;
        for (int i = 0; i <= lista.size() - 1; i++) {
            Aluno a = lista.get(i);
            if (a.getMatricula().equals(aluno.getMatricula())) {
                this.lista.remove(i);

                //Cria o texto e escreve no arquivo
                String txt = this.listaDeAlunosCSV();
                super.save(txt);
                return true;
            }
        }
        return false;
    }

}
