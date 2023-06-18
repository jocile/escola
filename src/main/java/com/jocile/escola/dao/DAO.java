package com.jocile.escola.dao;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joc
 */
public abstract class DAO {
    protected String pathArquivo;
    
    public DAO(){
        this.pathArquivo = "arquivo.txt";
    }

    public DAO(String pathArquivo) {
        this.pathArquivo = pathArquivo;
    }
    
    /**Deleta o objeto
     * @param obj
     * @return boolean
     */
    public abstract boolean delete(Object obj);
    
    protected void save(String txt){
        FileWriter arq = null;
        try {
            arq = new FileWriter(this.pathArquivo);
            PrintWriter gravaArq = new PrintWriter(arq);
            gravaArq.print(txt);
            arq.close();
        } catch (IOException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                arq.close();
            } catch (IOException ex){
                System.out.println(ex.getMessage());
            }
        }
        
    }
}
