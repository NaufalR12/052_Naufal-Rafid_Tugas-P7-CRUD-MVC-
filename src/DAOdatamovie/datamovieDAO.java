package DAOdatamovie;

import java.sql.*;
import java.util.*;
import koneksi.connector;
import model.*;
import DAOImplement.datamovieimplement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class datamovieDAO implements datamovieimplement {
    Connection connection;
     
    final String select = "SELECT * FROM movie";
    final String insert = "INSERT INTO movie (judul, alur, penokohan, akting, nilai) VALUES (?, ?, ?, ?, ?);";
    final String update = "UPDATE movie SET alur=?, penokohan=?, akting=?, nilai=? WHERE judul=?";
    final String delete = "DELETE FROM movie WHERE judul=?";
    
    public datamovieDAO() {
        connection = connector.connection();
    }

    @Override
    public void insert(datamovie p) {
        if (p.getJudul().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Judul harus diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return; 
        }
       
        double alur = p.getAlur();
        if (alur < 0 || alur > 5) {
            JOptionPane.showMessageDialog(null, "Nilai alur harus berada di antara 0 dan 5!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return; 
        }

        
        double penokohan = p.getPenokohan();
        if (penokohan < 0 || penokohan > 5) {
            JOptionPane.showMessageDialog(null, "Nilai penokohan harus berada di antara 0 dan 5!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return; 
        }

        
        double akting = p.getAkting();
        if (akting < 0 || akting > 5) {
            JOptionPane.showMessageDialog(null, "Nilai akting harus berada di antara 0 dan 5!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return; 
        }
    
    
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(insert);
            statement.setString(1, p.getJudul());
            statement.setDouble(2, p.getAlur());
            statement.setDouble(3, p.getPenokohan());
            statement.setDouble(4, p.getAkting());
            statement.setDouble(5, p.hitungNilaiRating());
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan!");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Gagal menambahkan data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void update(datamovie p) {
        if (p.getJudul().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Judul harus diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return; 
        }
       
        double alur = p.getAlur();
        if (alur < 0 || alur > 5) {
            JOptionPane.showMessageDialog(null, "Nilai alur harus berada di antara 0 dan 5!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return; 
        }

        
        double penokohan = p.getPenokohan();
        if (penokohan < 0 || penokohan > 5) {
            JOptionPane.showMessageDialog(null, "Nilai penokohan harus berada di antara 0 dan 5!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return; 
        }

        
        double akting = p.getAkting();
        if (akting < 0 || akting > 5) {
            JOptionPane.showMessageDialog(null, "Nilai akting harus berada di antara 0 dan 5!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return; 
        }
        
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(update);
            statement.setDouble(1, p.getAlur());
            statement.setDouble(2, p.getPenokohan());
            statement.setDouble(3, p.getAkting());
            statement.setDouble(4, p.hitungNilaiRating());
            statement.setString(5, p.getJudul());
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Data berhasil diubah!");
            } else {
                JOptionPane.showMessageDialog(null, "Gagal mengubah data!");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            
            JOptionPane.showMessageDialog(null, "Gagal mengubah data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void delete(String judul) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(delete);
            statement.setString(1, judul);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "Data berhasil dihapus!");
            } else {
                JOptionPane.showMessageDialog(null, "Gagal menghapus data!");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Gagal menghapus data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    @Override
    public int count() {
    int count = 0;
    try {
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery("SELECT COUNT(*) AS count FROM movie");
        if (rs.next()) {
            count = rs.getInt("count");
        }
    } catch (SQLException ex) {
        Logger.getLogger(datamovieDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return count;
}

    
    @Override
    public List<datamovie> getAll() {
        List<datamovie> dm = null;
        try {
            dm = new ArrayList<datamovie>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
                datamovie mv = new datamovie();
                mv.setJudul(rs.getString("judul"));
                mv.setAlur(rs.getDouble("alur"));
                mv.setPenokohan(rs.getDouble("penokohan"));
                mv.setAkting(rs.getDouble("akting"));
                mv.setNilai(rs.getDouble("nilai"));
                dm.add(mv);
            }
        } catch (SQLException ex) {
            Logger.getLogger(datamovieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dm;
    }
}
