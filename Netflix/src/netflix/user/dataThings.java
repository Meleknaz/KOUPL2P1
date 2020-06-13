package netflix.user;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static netflix.user.HomePage.butonlar;

public class dataThings extends db {

    ResultSet rs = null;

    public dataThings() {

    }

    public ResultSet onerilenGetir(String tur) {

        try {

            String sql = "SELECT * from ProgramTablosu p , programTur pt , turTablosu tb "
                    + "where p.programID = (SELECT pt.programID where pt.turID =(select tb.turID where tb.turName = ? )) order by proPuani DESC";

            PreparedStatement pst;
            pst = conn.prepareStatement(sql);

            pst.setString(1, tur);

            rs = pst.executeQuery();

        } catch (SQLException ex) {
            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);

        }

        return rs;
    }

    public ResultSet tumFilmGetir() {

        String sql = "select * from ProgramTablosu ";

        ResultSet rs = null;

        try {
            PreparedStatement pst;
            pst = conn.prepareStatement(sql);

            rs = pst.executeQuery();

            if (rs.next()) {
                return rs;
            } else {
                return null;

            }

        } catch (SQLException ex) {
            Logger.getLogger(LoginPage.class
                    .getName()).log(Level.SEVERE, null, ex);
            return rs;
        }

    }

    public ResultSet searchFilm(String search) {

        String sql = "select * from ProgramTablosu where proName LIKE '%" + search + "%' or proTip LIKE '%" + search + "%' ";

        ResultSet rs = null;

        try {
            PreparedStatement pst;
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            if (rs.next()) {
                return rs;
            } else {
                return null;

            }

        } catch (SQLException ex) {
            Logger.getLogger(LoginPage.class
                    .getName()).log(Level.SEVERE, null, ex);
            return rs;
        }

    }

    public ResultSet filmBilgisiGetir(String film_adi) {

        String sql = "select * from ProgramTablosu where proName =? ";

        ResultSet rs = null;

        try {

            PreparedStatement pst;
            pst = conn.prepareStatement(sql);
            pst.setString(1, film_adi);
            rs = pst.executeQuery();

            if (rs.next()) {
                return rs;
            } else {
                return null;

            }

        } catch (SQLException ex) {
            Logger.getLogger(LoginPage.class
                    .getName()).log(Level.SEVERE, null, ex);
            return rs;
        }

    }

    void kullaniciProTabloyaEkle(int kullaniciID, int proID, String toplamIzlenmeSuresi, int bolum, int verdigiPuan) {

        String sql = "insert into kullaniciProgram( KullaniciID , programID , IzlenmeTarihi ,KacinciDkKaldi, HangiBolumdeKaldi,VerdigiPuan )  values(?,?,?,?,?,?)";

        try {

            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, kullaniciID);
            pstmt.setInt(2, proID);
            pstmt.setString(3, LocalDate.now().toString());
            pstmt.setString(4, toplamIzlenmeSuresi);
            pstmt.setInt(5, bolum);
            pstmt.setInt(6, verdigiPuan);
            pstmt.execute();
            pstmt.close();

        } catch (SQLException e) {

        }

    }

    public ResultSet izlenmeBilgisiGetir(int kullaniciID, int proID) {

        String sql = "select * from kullaniciProgram where kullaniciID=? and programID=? ";

        ResultSet rs = null;

        try {

            PreparedStatement pst;
            pst = conn.prepareStatement(sql);
            pst.setInt(1, kullaniciID);
            pst.setInt(2, proID);
            rs = pst.executeQuery();

            if (rs.next()) {
                return rs;
            } else {
                return null;

            }

        } catch (SQLException ex) {
            Logger.getLogger(LoginPage.class
                    .getName()).log(Level.SEVERE, null, ex);
            return rs;
        }

    }

    public void izlenmeBilgisiUpdate(int kullaniciID, int proID, String dk, int Puan) {

        String sql = "update kullaniciProgram set KacinciDkKaldi=?, VerdigiPuan=? where kullaniciID = ? and programID = ?";

        ResultSet rs = null;

        try {

            PreparedStatement pst;
            pst = conn.prepareStatement(sql);
            pst.setString(1, dk);
            pst.setInt(2, Puan);
            pst.setInt(3, kullaniciID);
            pst.setInt(4, proID);
            
            pst.execute();

        } catch (SQLException ex) {
            Logger.getLogger(LoginPage.class
                    .getName()).log(Level.SEVERE, null, ex);

        }

    }

}
