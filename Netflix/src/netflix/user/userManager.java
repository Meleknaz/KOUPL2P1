package netflix.user;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class userManager extends db {

    private user kullanici;

    public userManager(user kullanici) {

        this.kullanici = kullanici;

    }

    public userManager() {

    }

    public void register() {

    }

    public void login() {

        String sql = "Select distinct * from kullanici where email=? and sifre=?";
        ResultSet rs = null;

        try {
            PreparedStatement pst;
            pst = conn.prepareStatement(sql);

            pst.setString(1, getKullanici().getEmail());
            pst.setString(2, getKullanici().getSifre());

            rs = pst.executeQuery();

            if (rs.next()) {
                getKullanici().setEmail(rs.getString("email"));
                getKullanici().setSifre(rs.getString("sifre"));
                getKullanici().setAdi(rs.getString("adi"));
                String[] x = {rs.getString("tur1"), rs.getString("tur2"), rs.getString("tur3")};
                getKullanici().setTurler(x);
                getKullanici().setKullaniciID(rs.getInt("kullaniciID"));
                getKullanici().setDogumTarihi(rs.getString("dogumTarihi"));

                getKullanici().setAuth(true);
            }
            

        } catch (SQLException ex) {
            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    public void logOut() {

        getKullanici().setAuth(false);

    }

    public user getKullanici() {
        return kullanici;
    }

    public void setKullanici(user kullanici) {
        this.kullanici = kullanici;
    }

}
