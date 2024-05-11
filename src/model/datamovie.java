/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class datamovie {
    private String judul;
    private double alur;
    private double penokohan;
    private double akting; 
    private double nilai; 

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public double getAlur() {
        return alur;
    }

    public void setAlur(double alur) {
      
        this.alur = alur;
    }

    public double getPenokohan() {
        return penokohan;

    }

    public void setPenokohan(double penokohan) {
       
        this.penokohan = penokohan;
    }

    public double getAkting() {
       
        return akting;
    }

    public void setAkting(double akting) {
       
        this.akting = akting;
    }

    public double getNilai() {
        return nilai;
    }

    public void setNilai(double nilai) {
        this.nilai = nilai;
    }
    
    public double hitungNilaiRating() {
        return (alur + penokohan + akting) / 3.0;
    }

   
}
