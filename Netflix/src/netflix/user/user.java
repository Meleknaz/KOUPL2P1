package netflix.user;

public class user {

    private String adi;
    private String sifre;
    private String email;
    private String dogumTarihi;
    private int kullaniciID;
    private String[] turler;
    private boolean Auth;

  
    
    
    public user() {
            
    }

    public user(String adi,String sifre,String email,String dogumTarihi,int kullaniciID,String[] turler) {
        
        this.Auth=false;
        this.adi=adi;
        this.dogumTarihi=dogumTarihi;
        this.email=email;
        this.kullaniciID=kullaniciID;
        this.sifre=sifre;
        this.turler=turler;
        
        
        
        
        
    }
    
    public String getTur(int index){
        
        
        return getTurler()[index];
    }
    
      
  public boolean IsAuth() {
        return Auth;
    }

    public void setAuth(boolean Auth) {
        this.Auth = Auth;
    }
    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDogumTarihi() {
        return dogumTarihi;
    }

    public void setDogumTarihi(String dogumTarihi) {
        this.dogumTarihi = dogumTarihi;
    }

    public int getKullaniciID() {
        return kullaniciID;
    }

    public void setKullaniciID(int kullaniciID) {
        this.kullaniciID = kullaniciID;
    }

    public String[] getTurler() {
        return turler;
    }

    public void setTurler(String[] turler) {
        this.turler = turler;
    }

}
