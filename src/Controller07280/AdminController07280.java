package Controller07280;

import Entity07280.AdminEntity07280;

public class AdminController07280 {
    public void insertData(String nip,String nama, String alamat, String password, String noTelp){
        AllObjectModel07280.adminModel07280.insertData(new AdminEntity07280(nip,nama,alamat,password,noTelp));
    }
    public void updatePassword(String password, int id){
        AllObjectModel07280.adminModel07280.updatePassword(password,id);
    }
    public void updateNoTelp(String noTelp, int id){
        AllObjectModel07280.adminModel07280.updateNoTelp(noTelp,id);
    }
    public int cekLogin(String nip, String password){
       int login = AllObjectModel07280.adminModel07280.cekLogin(nip,password);
       return login;
    }
    public void deleteData(int id){
        AllObjectModel07280.adminModel07280.deleteData(id);
    }


}
