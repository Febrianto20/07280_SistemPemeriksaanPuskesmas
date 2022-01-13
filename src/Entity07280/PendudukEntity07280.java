package Entity07280;

public class PendudukEntity07280 extends UserEntityAbstract07280 {
    public String nip, diagnosis, klhn_penyakit;

    public PendudukEntity07280(String nip, String nama, String alamat, String noTelp, String diagnosis, String klhn_penyakit){
        super(nama, alamat, noTelp);
        this.nip = nip;
        this.diagnosis = diagnosis;
        this.klhn_penyakit = klhn_penyakit;
    }

    public PendudukEntity07280(int id, String nama, String alamat, String noTelp, String nip, String diagnosis, String klhn_penyakit) {
        super(nama, alamat, noTelp, id);
        this.nip = nip;
        this.diagnosis = diagnosis;
        this.klhn_penyakit = klhn_penyakit;
    }
    public PendudukEntity07280(){}

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getdiagnosis() {
        return diagnosis;
    }

    public void setdiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getklhn_penyakit() {
        return klhn_penyakit;
    }

    public void setklhn_penyakit(String klhn_penyakit) {
        this.klhn_penyakit = klhn_penyakit;
    }
}
