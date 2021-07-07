/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cefronteira;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class solucaoCandidata {
    
    int f1;
    int f2;
    String Nome;
    ArrayList<solucaoCandidata> Sp = new ArrayList<solucaoCandidata>();
    int np;
    int rank ;

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public ArrayList<solucaoCandidata> getSp() {
        return Sp;
    }

    public void setSp(ArrayList<solucaoCandidata> Sp) {
        this.Sp = Sp;
    }

    public int getNp() {
        return np;
    }

    public void setNp(int np) {
        this.np = np;
    }

   

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }


    
    public int getF1() {
        return f1;
    }

    public void setF1(int f1) {
        this.f1 = f1;
    }

    public int getF2() {
        return f2;
    }

    public void setF2(int f2) {
        this.f2 = f2;
    }

    
    public solucaoCandidata(int f1, int f2, String Nome) {
        this.f1 = f1;
        this.f2 = f2;
        this.Nome = Nome;
    }
    
    
}