package Controller07280;

import Entity07280.PendudukEntity07280;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class PendudukController07280 {

    public void insertData(String nip,String nama, String alamat, String noTelp, String diagnosis, String klhn_penyakit){
        AllObjectModel07280.pendudukModel.insertData(new PendudukEntity07280(nip, nama, alamat, noTelp, diagnosis, klhn_penyakit));
    }
    public void updatediagnosis(String diagnosis, int id){
        AllObjectModel07280.pendudukModel.updatediagnosis(diagnosis,id);
    }
    public void updateNoTelp(String noTelp, int id){
        AllObjectModel07280.pendudukModel.updateNoTelp(noTelp,id);
    }
    public ArrayList<PendudukEntity07280> getDataPenduduk(String nip) {
        return AllObjectModel07280.pendudukModel.getPenduduk(nip);
    }
    public ArrayList<PendudukEntity07280> getDataPenduduk() {
        return AllObjectModel07280.pendudukModel.getPenduduk();
    }
    public int CekData(String nip){
        int cek = AllObjectModel07280.pendudukModel.cekData(nip);
        return cek;
    }
    public DefaultTableModel daftarPenduduk(){
        DefaultTableModel dataDaftarPenduduk = new DefaultTableModel();
        Object[] kolom = {"ID", "NIP", "NAMA", "ALAMAT", "NOTELP", "DIAGNOSIS", "Klhn_penyakit"};
        dataDaftarPenduduk.setColumnIdentifiers(kolom);
        int size = getDataPenduduk().size();
        for(int i = 0; i < size; i++ ){
            Object[] data = new Object[7];
            data[0] = AllObjectModel07280.pendudukModel.getPenduduk().get(i).getId();
            data[1] = AllObjectModel07280.pendudukModel.getPenduduk().get(i).getNip();
            data[2] = AllObjectModel07280.pendudukModel.getPenduduk().get(i).getNama();
            data[3] = AllObjectModel07280.pendudukModel.getPenduduk().get(i).getAlamat();
            data[4] = AllObjectModel07280.pendudukModel.getPenduduk().get(i).getNoTelp();
            data[5] = AllObjectModel07280.pendudukModel.getPenduduk().get(i).getdiagnosis();
            data[6] = AllObjectModel07280.pendudukModel.getPenduduk().get(i).getklhn_penyakit();
            dataDaftarPenduduk.addRow(data);
        }
        return dataDaftarPenduduk;
    }

    public Iterable<PendudukEntity07280> getDataPenduduk(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
