package GUI;

import Controller07280.PendudukController07280;
import Entity07280.PendudukEntity07280;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DataPeroranganGui extends JFrame {
    String Nip,Nama,alamat,noTelp,diagnosis,klhn_penyakit;
    int id;

    DataPeroranganGui(String nip, int id){
        init(nip);
    }

    public void init(String nip){

        PendudukController07280 pendudukController07280 = new PendudukController07280();



        for(PendudukEntity07280 pendudukEntity07280 : pendudukController07280.getDataPenduduk(nip)){
            this.id = pendudukEntity07280.getId();
            this.Nip = pendudukEntity07280.getNip();
            this.Nama= pendudukEntity07280.getNama();
            this.alamat = pendudukEntity07280.getAlamat();
            this.noTelp = pendudukEntity07280.getNoTelp();
            this.diagnosis= pendudukEntity07280.getdiagnosis();
            this.klhn_penyakit= pendudukEntity07280.getklhn_penyakit();
        }

        JTextField fieldNip = new JTextField();
        JTextField fieldNama = new JTextField();
        JTextField fieldAlamat = new JTextField();
        JTextField fieldNoTelp = new JTextField();
        JTextField fielddiagnosis = new JTextField();
        JTextField fieldklhn_penyakit = new JTextField();

        setBounds(100, 100, 707, 599);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        JButton btnKembali = new JButton("Kembali");
        btnKembali.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        btnKembali.setBounds(10, 10, 110, 34);
        getContentPane().add(btnKembali);

        btnKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DataPendGui(id).setVisible(true);
                dispose();
            }
        });

        JLabel lblNewLabel = new JLabel("Nip");
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNewLabel.setBounds(10, 107, 110, 39);
        getContentPane().add(lblNewLabel);

        fieldNip.setBounds(158, 115, 251, 27);
        fieldNip.setColumns(10);
        fieldNip.setText(this.Nip);
        fieldNip.setEditable(false);
        getContentPane().add(fieldNip);


        JLabel lblNewLabel_1 = new JLabel("NAMA");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNewLabel_1.setBounds(10, 186, 83, 13);
        getContentPane().add(lblNewLabel_1);

        fieldNama.setColumns(10);
        fieldNama.setBounds(158, 172, 251, 27);
        fieldNama.setText(this.Nama);
        fieldNama.setEditable(false);
        getContentPane().add(fieldNama);

        JLabel lblNewLabel_2 = new JLabel("ALAMAT");
        lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNewLabel_2.setBounds(10, 243, 110, 24);
        getContentPane().add(lblNewLabel_2);

        fieldAlamat.setColumns(10);
        fieldAlamat.setBounds(158, 240, 251, 27);
        fieldAlamat.setText(this.alamat);
        fieldAlamat.setEditable(false);
        getContentPane().add(fieldAlamat);

        JLabel lblNewLabel_3 = new JLabel("NO TELP");
        lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNewLabel_3.setBounds(10, 306, 110, 27);
        getContentPane().add(lblNewLabel_3);

        fieldNoTelp.setColumns(10);
        fieldNoTelp.setBounds(158, 306, 251, 27);
        fieldNoTelp.setText(this.noTelp);
        fieldNoTelp.setEditable(false);
        getContentPane().add(fieldNoTelp);

        JLabel lblNewLabel_4 = new JLabel("Diagnosa");
        lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNewLabel_4.setBounds(10, 379, 110, 19);
        getContentPane().add(lblNewLabel_4);

        fielddiagnosis.setColumns(10);
        fielddiagnosis.setBounds(158, 371, 251, 27);
        fielddiagnosis.setText(this.diagnosis);
        fielddiagnosis.setEditable(false);
        getContentPane().add(fielddiagnosis);

        JLabel lblNewLabel_5 = new JLabel("JENIS Penyakit");
        lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNewLabel_5.setBounds(10, 435, 132, 27);
        getContentPane().add(lblNewLabel_5);

        fieldklhn_penyakit.setColumns(10);
        fieldklhn_penyakit.setBounds(158, 435, 251, 27);
        fieldklhn_penyakit.setText(this.klhn_penyakit);
        fieldklhn_penyakit.setEditable(false);
        getContentPane().add(fieldklhn_penyakit);

        JButton btnUbahdiagnosis = new JButton("Ubah");
        btnUbahdiagnosis.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        btnUbahdiagnosis.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    String diagnosis = JOptionPane.showInputDialog("Masukan Diagnosis Baru");
                    if(diagnosis.length() > 0){
                        pendudukController07280.updatediagnosis(diagnosis,id);
                        JOptionPane.showMessageDialog(null,"Berhasil dirubah");
                        fielddiagnosis.setText(diagnosis);
                    } else {
                        JOptionPane.showMessageDialog(null, "Data Kosong");
                    }
                } catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Cancelled");
                }
            }
        });
        btnUbahdiagnosis.setBounds(470, 371, 103, 29);
        getContentPane().add(btnUbahdiagnosis);

        JButton btnUbahNoTelp = new JButton("Ubah");
        btnUbahNoTelp.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        btnUbahNoTelp.setBounds(470, 311, 103, 29);
        getContentPane().add(btnUbahNoTelp);

        btnUbahNoTelp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String noTelp = JOptionPane.showInputDialog("Masukan NoTelp Baru");
                    if(noTelp.length() > 0){
                        pendudukController07280.updateNoTelp(noTelp,id);
                        JOptionPane.showMessageDialog(null,"Berhasil dirubah");
                        fieldNoTelp.setText(noTelp);
                    } else {
                        JOptionPane.showMessageDialog(null, "Data Kosong");
                    }
                } catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Cancelled");
                }
            }
        });
    }
}
