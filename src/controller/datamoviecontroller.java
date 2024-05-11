/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.util.List;
import DAOdatamovie.datamovieDAO;
import DAOImplement.datamovieimplement;
import javax.swing.JOptionPane;
import model.*;
import view.MainView;
/**
 *
 * @author LENOVO
 */
public class datamoviecontroller {
    MainView frame;
    datamovieimplement impldatamovie;
    List<datamovie> dm;
    
    public datamoviecontroller(MainView frame) {
        this.frame = frame;
        impldatamovie = new datamovieDAO();
        dm = impldatamovie.getAll();
    }
    
    public void isitabel(){
        dm = impldatamovie.getAll();
        modeltabeldatamovie mm = new modeltabeldatamovie(dm);
        frame.getTabelDatamovie().setModel(mm);
        int count = impldatamovie.count();
    frame.getJTxtjumlah().setText(Integer.toString(count));

    }
    
    public void insert(){
    try {
        datamovie dm = new datamovie();
        dm.setJudul(frame.getJTxtjudul().getText());
        dm.setAlur(Double.parseDouble(frame.getJTxtalur().getText()));
        dm.setPenokohan(Double.parseDouble(frame.getJTxtpenokohan().getText()));
        dm.setAkting(Double.parseDouble(frame.getJTxtakting().getText()));
        impldatamovie.insert(dm);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Input tidak valid. Harap masukkan nilai yang sesuai, jangan dikosongkan!", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

public void update(){
    try {
        datamovie dm = new datamovie();
        dm.setJudul(frame.getJTxtjudul().getText());
        dm.setAlur(Double.parseDouble(frame.getJTxtalur().getText()));
        dm.setPenokohan(Double.parseDouble(frame.getJTxtpenokohan().getText()));
        dm.setAkting(Double.parseDouble(frame.getJTxtakting().getText()));
        impldatamovie.update(dm);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Input tidak valid. Harap masukkan nilai yang sesuai, jangan dikosongkan!", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

    
    public void delete(){
        try {
        String judul = frame.getJTxtjudul().getText();
            if(judul.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Silakan pilih data yang ingin dihapus!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            } else {
                impldatamovie.delete(judul);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan saat menghapus data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void reset() {
        frame.getJTxtjudul().setText(""); 
        frame.getJTxtalur().setText(""); 
        frame.getJTxtpenokohan().setText(""); 
        frame.getJTxtakting().setText("");
        frame.getJTxtnilai().setText("");
    }
    
   

    
}
