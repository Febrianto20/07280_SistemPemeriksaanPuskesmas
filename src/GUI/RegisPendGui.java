package GUI;

import Controller07280.PendudukController07280;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisPendGui extends JFrame {

    PendudukController07280 Penduduk = new PendudukController07280();

    RegisPendGui(int id){
        init(id);
    }

    public void init(int id){
        setBounds(100, 100, 826, 597);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        JTextField fieldNip = new JTextField();
        JTextField fieldNama = new JTextField();
        JTextField fieldAlamat = new JTextField();
        JTextField fieldNoTelp = new JTextField();
        JTextField fielddiagnosis = new JTextField();
        JTextField fieldklhn_penyakit = new JTextField();

        JLabel lblNama = new JLabel("Nama");
        lblNama.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lblNama.setBounds(10, 142, 107, 50);
        getContentPane().add(lblNama);

        JLabel lblAlamat = new JLabel("Alamat");
        lblAlamat.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lblAlamat.setBounds(10, 204, 107, 50);
        getContentPane().add(lblAlamat);

        JLabel lblNotelp = new JLabel("NoTelp");
        lblNotelp.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lblNotelp.setBounds(10, 272, 107, 50);
        getContentPane().add(lblNotelp);

        JLabel lbldiagnosis = new JLabel("diagnosis");
        lbldiagnosis.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lbldiagnosis.setBounds(10, 342, 107, 50);
        getContentPane().add(lbldiagnosis);

        JLabel lblklhn_penyakitt = new JLabel("Keluhan Penyakit");
        lblklhn_penyakitt.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lblklhn_penyakitt.setBounds(10, 409, 107, 50);
        getContentPane().add(lblklhn_penyakitt);

        JLabel lblNip = new JLabel("NIP");
        lblNip.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lblNip.setBounds(10, 81, 107, 50);
        getContentPane().add(lblNip);

        fieldNip.setColumns(10);
        fieldNip.setBounds(184, 93, 286, 31);
        getContentPane().add(fieldNip);

        fieldNama.setColumns(10);
        fieldNama.setBounds(184, 154, 286, 31);
        getContentPane().add(fieldNama);

        fieldAlamat.setColumns(10);
        fieldAlamat.setBounds(184, 216, 286, 31);
        getContentPane().add(fieldAlamat);

        fieldNoTelp.setColumns(10);
        fieldNoTelp.setBounds(184, 284, 286, 31);
        getContentPane().add(fieldNoTelp);

        fielddiagnosis.setColumns(10);
        fielddiagnosis.setBounds(184, 354, 286, 31);
        getContentPane().add(fielddiagnosis);

        fieldklhn_penyakit.setColumns(10);
        fieldklhn_penyakit.setBounds(184, 421, 286, 31);
        getContentPane().add(fieldklhn_penyakit);

        JLabel lblPen = new JLabel("REGISTRASI PENDUDUK");
        lblPen.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblPen.setBounds(212, 27, 242, 42);
        getContentPane().add(lblPen);

        JButton btnRegPend = new JButton("REGISTRASI");
        btnRegPend.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnRegPend.setBounds(254, 491, 173, 42);
        getContentPane().add(btnRegPend);

        btnRegPend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nip = fieldNip.getText();
                String Nama = fieldNama.getText();
                String Alamat = fieldAlamat.getText();
                String NoTelp = fieldNoTelp.getText();
                String diagnosis = fielddiagnosis.getText();
                String klhn_penyakit = fieldklhn_penyakit.getText();

                Penduduk.insertData(nip,Nama,Alamat,NoTelp,diagnosis,klhn_penyakit);
                JOptionPane.showMessageDialog(null, "Berhasil Ditambah");
                new MenuAdminGui(id).setVisible(true);
                dispose();
            }
        });
    }
}
