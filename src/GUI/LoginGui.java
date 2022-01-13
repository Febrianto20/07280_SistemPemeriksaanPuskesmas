package GUI;

import Controller07280.AdminController07280;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginGui extends JFrame {
    public LoginGui(){
        init();
    }
    public void init(){

        AdminController07280 admin = new AdminController07280();
        String pathicon = "./src/Gambar/Login.png";
        
        JTextField fieldNip = new JTextField();
        JPasswordField fieldPass = new JPasswordField();

        setBounds(100, 100, 675, 753);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        setLocationRelativeTo(null);
        JLabel bingkaigambar = new JLabel();
        bingkaigambar.setBounds(182, 102, 286, 192);
        add(bingkaigambar);

        BufferedImage bufferedImage = null;
        Image gambarresize;


        try{
            bufferedImage = ImageIO.read(new File(pathicon));
        } catch (IOException ex) {
            Logger.getLogger(LoginGui.class.getName()).log(Level.SEVERE, null, ex);
        }
        gambarresize = bufferedImage.getScaledInstance(286, 192,    Image.SCALE_SMOOTH);
        bingkaigambar.setIcon(new ImageIcon(gambarresize));

//        JPanel panel = new JPanel();
//        panel.setBackground(Color.RED);
//        panel.setBounds(182, 102, 286, 192);
//        getContentPane().add(panel);

        JLabel lblNewLabel = new JLabel("NIP");
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        lblNewLabel.setBounds(76, 391, 94, 47);
        getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("PASSWORD");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        lblNewLabel_1.setBounds(76, 482, 173, 53);
        getContentPane().add(lblNewLabel_1);
        
        fieldNip.setBounds(295, 397, 173, 47);
        getContentPane().add(fieldNip);
        fieldNip.setColumns(10);

        fieldPass.setColumns(10);
        fieldPass.setBounds(295, 491, 173, 47);
        getContentPane().add(fieldPass);

        JButton btnAddAdmin = new JButton("REGISTRASI ADMIN");
        btnAddAdmin.setBackground(new Color(240, 240, 240));
        btnAddAdmin.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        btnAddAdmin.setBounds(209, 685, 226, 21);
        getContentPane().add(btnAddAdmin);

        btnAddAdmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegisAdminGui().setVisible(true);
                dispose();
            }
        });

        JLabel lblNewLabel_2 = new JLabel("LOGIN ADMIN");
        lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        lblNewLabel_2.setBounds(10, 10, 109, 13);
        getContentPane().add(lblNewLabel_2);

        JButton btnLogin = new JButton("LOGIN");
        btnLogin.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        btnLogin.setBounds(252, 581, 136, 39);
        getContentPane().add(btnLogin);
        setVisible(true);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String NIP = fieldNip.getText();
                String Password = fieldPass.getText();

                int cek = admin.cekLogin(NIP,Password);
                if(cek > 0){
                    JOptionPane.showMessageDialog(null, "Login Berhasil");
                    new MenuAdminGui(cek).setVisible(true);
                    dispose();
                }else{
                    JOptionPane.showMessageDialog(null, "Login Gagal");
                }
            }
        });
}


    public static void main(String[] args) {
        LoginGui init = new LoginGui();
    }

}
