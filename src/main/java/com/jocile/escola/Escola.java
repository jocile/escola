package com.jocile.escola;

import com.jocile.escola.entidades.*;
import java.util.ArrayList;
import java.util.List;


public class Escola {

    public static void main(String[] args) {
        //Criar uma disciplina
        Disciplina disciplina1 = new Disciplina();
        preencher(disciplina1);
        imprimir(disciplina1);
        
    }
    
    public static void preencher(Disciplina disciplina){
        
        //Criar uma lista de alunos
        List<Aluno> lstAluno = new ArrayList();
        //Criar 5 alunos
        Aluno aluno1 = new Aluno();
        aluno1.setNome("Lucas");
        Aluno aluno2 = new Aluno();
        aluno2.setNome("joão");
        Aluno aluno3 = new Aluno();
        aluno3.setNome("pedro");
        Aluno aluno4 = new Aluno();
        aluno4.setNome("Verice");
        Aluno aluno5 = new Aluno();
        aluno5.setNome("Wallison");
        //Adicionar os alunos na lista
        lstAluno.add(aluno1);
        lstAluno.add(aluno2);
        lstAluno.add(aluno3);
        lstAluno.add(aluno4);
        lstAluno.add(aluno5);
        //Adicionar a lista na disciplina
        disciplina.setLstAluno(lstAluno);
    }
    
    public static void imprimir(Disciplina disciplina){
        List<Aluno> lstAluno = disciplina.getLstAluno();
        
        for (int i = 0; i < lstAluno.size(); i++) {
      System.out.println(lstAluno.get(i).getNome());
    }
    }
}
