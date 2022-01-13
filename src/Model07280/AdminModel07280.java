package Model07280;

import Entity07280.AdminEntity07280;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminModel07280 extends ModelAbstract07280 {
    private String sql;

    @Override
    public void updatenoTelp(String noTelp, int id) {
    }

    public void insertData(AdminEntity07280 adminEntity07280) {
        try {
            sql = "INSERT INTO admin(nip, nama, alamat, password, noTelp)" +
                    "VALUE(?,?,?,?,?)";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, adminEntity07280.getNip());
            stat.setString(2, adminEntity07280.getNama());
            stat.setString(3, adminEntity07280.getAlamat());
            stat.setString(4, adminEntity07280.getPassword());
            stat.setString(5, adminEntity07280.getNoTelp());
            stat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePassword(String password, int id) {
        try {
            sql = "UPDATE admin SET password = ? WHERE id = ? ";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, password);
            stat.setInt(2, id);
            int rows = stat.executeUpdate();
            System.out.println(rows + " row(s) updated ");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateNoTelp(String noTelp, int id) {
        try {
            sql = "UPDATE admin SET noTelp = ? WHERE id = ? ";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, noTelp);
            stat.setInt(2, id);
            int rows = stat.executeUpdate();
            System.out.println(rows + " row(s) updated ");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int cekLogin(String nip, String password) {
        int cek = 0;
        try {
            sql = "SELECT * FROM admin WHERE nip = ? AND password = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, nip);
            stat.setString(2, password);
            ResultSet rs = stat.executeQuery();
            if (rs.next()) {
                cek = rs.getInt("id");
                String nama = rs.getString("nama");
            } else {
                cek = 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cek;
    }

    public void deleteData(int id) {
        try {
            sql = "DELETE FROM penduduk WHERE id = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, id);
            stat.executeUpdate();
            System.out.println("Data penduduk dengan id: "+id + " Berhasil dihapus");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
