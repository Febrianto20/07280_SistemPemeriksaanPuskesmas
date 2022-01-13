package Model07280;

import Entity07280.PendudukEntity07280;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PendudukModel07280 extends ModelAbstract07280 {
    private String sql;

    public void insertData(PendudukEntity07280 pendudukEntity07280){
        try{
            sql = "INSERT INTO penduduk(nip, nama, alamat, noTelp, diagnosis, klhn_penyakit)" +
                    "VALUE(?,?,?,?,?,?)";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, pendudukEntity07280.getNip());
            stat.setString(2, pendudukEntity07280.getNama());
            stat.setString(3, pendudukEntity07280.getAlamat());
            stat.setString(4, pendudukEntity07280.getNoTelp());
            stat.setString(5, pendudukEntity07280.getdiagnosis());
            stat.setString(6, pendudukEntity07280.getklhn_penyakit());
            stat.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
 }
    public void updatediagnosis(String diagnosis, int id){
        try{
            sql = "UPDATE penduduk SET diagnosis = ? WHERE id = ? ";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, diagnosis);
            stat.setInt(2, id);
            int rows = stat.executeUpdate();
            System.out.println(rows+" row(s) updated ");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public ArrayList<PendudukEntity07280> getPenduduk(String nip){
        ArrayList<PendudukEntity07280> arrPenduduk = new ArrayList<>();

        try{
            sql = "SELECT * FROM penduduk where nip = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1,nip);
            ResultSet rs = stat.executeQuery();
            while(rs.next()){
                PendudukEntity07280 pendudukEntity07280 = new PendudukEntity07280();
                pendudukEntity07280.setId(rs.getInt("id"));
                pendudukEntity07280.setNama(rs.getString("nama"));
                pendudukEntity07280.setAlamat(rs.getString("alamat"));
                pendudukEntity07280.setNoTelp(rs.getString("noTelp"));
                pendudukEntity07280.setNip(rs.getString("nip"));
                pendudukEntity07280.setdiagnosis(rs.getString("diagnosis"));
                pendudukEntity07280.setklhn_penyakit(rs.getString("klhn_penyakit"));
                arrPenduduk.add(pendudukEntity07280);
            }
        }catch (SQLException e){
            System.out.println(e);
        }
        return arrPenduduk;
    }

    public ArrayList<PendudukEntity07280> getPenduduk(){
        ArrayList<PendudukEntity07280> arrPenduduk = new ArrayList<>();

        try{
            sql = "SELECT * FROM penduduk";
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()){
                PendudukEntity07280 pendudukEntity07280 = new PendudukEntity07280();
                pendudukEntity07280.setId(rs.getInt("id"));
                pendudukEntity07280.setNama(rs.getString("nama"));
                pendudukEntity07280.setAlamat(rs.getString("alamat"));
                pendudukEntity07280.setNoTelp(rs.getString("noTelp"));
                pendudukEntity07280.setNip(rs.getString("nip"));
                pendudukEntity07280.setdiagnosis(rs.getString("diagnosis"));
                pendudukEntity07280.setklhn_penyakit(rs.getString("klhn_penyakit"));
                arrPenduduk.add(pendudukEntity07280);
            }
        }catch (SQLException e){
            System.out.println(e);
        }
        return arrPenduduk;
    }

    @Override
    public void updatenoTelp(String noTelp, int id) {
        try{
            sql = "UPDATE penduduk SET noTelp = ? WHERE id = ? ";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, noTelp);
            stat.setInt(2, id);
            int rows = stat.executeUpdate();
            System.out.println(rows+" row(s) updated ");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateNoTelp(String noTelp, int id){
        try{
            sql = "UPDATE penduduk SET noTelp = ? WHERE id = ? ";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, noTelp);
            stat.setInt(2, id);
            int rows = stat.executeUpdate();
            System.out.println(rows+" row(s) updated ");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public int cekData(String nip){
        int cek = 0;
        try{
            sql = "SELECT * FROM penduduk WHERE nip = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1,nip);
            ResultSet rs = stat.executeQuery();

            if(rs.next()){
                cek = rs.getInt("id");
            }else {
                cek = 0;
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return cek;
    }
}
