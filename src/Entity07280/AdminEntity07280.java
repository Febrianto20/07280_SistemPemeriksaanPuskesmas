package Entity07280;

public class AdminEntity07280 extends UserEntityAbstract07280 {
    private String nip, password;

    public AdminEntity07280(){
    }
    public AdminEntity07280(String nip, String nama, String alamat, String password, String noTelp){
        super(nama, alamat, noTelp);
        this.nip = nip;
        this.password = password;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

