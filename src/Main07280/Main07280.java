package Main07280;

import Controller07280.AdminController07280;
import Controller07280.PendudukController07280;
import Entity07280.PendudukEntity07280;

import java.util.Scanner;

public class Main07280 {
    public static AdminController07280 adminController07280 = new AdminController07280();
    public static PendudukController07280 pendudukController07280 = new PendudukController07280();
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int pil;
        do {
            System.out.println("1. Login Admin");
            System.out.println("2. Registrasi Admin");
            System.out.println("Masukkan Pilihan: ");
            pil = input.nextInt();
            input.nextLine();

            switch (pil) {
                case 1 -> loginAdmin();
                case 2 -> regisData();
            }
        } while (pil != 0);
    }

    static void loginAdmin() {
        int pil;
        String nip, password;

        System.out.println("Masukkan NIP: ");
        nip = input.nextLine();
        System.out.println("Masukkan Password: ");
        password = input.next();
        int cek = adminController07280.cekLogin(nip, password);
        if (cek != 0) {
            System.out.println("Berhasil Login");
            menu();
        } else {
            System.out.println("Gagal Login");
        }
    }

    static void menu() {
        int pil;
        do {
            System.out.println("1. ADMIN");
            System.out.println("2. PENDUDUK");
            System.out.println("Masukkan Inputan: ");
            pil = input.nextInt();

            switch (pil) {
                case 1 -> menuAdmin();
                case 2 -> menuPenduduk();
            }
        } while (pil != 0);
    }

    static void menuAdmin() {
        int pil;
        do {
            System.out.println("1. Update Passwordd");
            System.out.println("2. Update NoTelp");
            System.out.println("3. Hapus Data");
            System.out.println("0. Log Out");
            System.out.print("Pilih: ");
            pil = input.nextInt();
            input.nextLine();
            switch (pil) {
                case 1:
                    updatepassword();
                    break;
                case 2:
                    updatenotelp();
                    break;
                case 3:
                    deleteData();
                    break;
            }
        } while (pil != 0);
    }

    static void regisData() {
        int id;
        String nip, nama, alamat, password, noTelp;

        System.out.println("Masukkan id: ");
        id = input.nextInt();
        input.nextLine();
        System.out.println("Masukkan NIP: ");
        nip = input.nextLine();
        System.out.println("Masukkan Nama: ");
        nama = input.nextLine();
        System.out.println("Masukkan Alamat: ");
        alamat = input.nextLine();
        System.out.println("Masukkan Password: ");
        password = input.nextLine();
        System.out.println("Masukkan No Telp: ");
        noTelp = input.nextLine();

        adminController07280.insertData(nip, nama, alamat, password, noTelp);
    }

    static void updatepassword() {
        String password;
        int id;
        System.out.println("Masukkan id: ");
        id = input.nextInt();
        input.nextLine();
        System.out.println("Masukkan password baru: ");
        password = input.nextLine();
        adminController07280.updatePassword(password, id);
    }

    static void updatenotelp() {
        String noTelp;
        int id;
        System.out.println("Masukkan id: ");
        id = input.nextInt();
        input.nextLine();
        System.out.println("Masukkan No Telp baru: ");
        noTelp = input.nextLine();
        adminController07280.updateNoTelp(noTelp, id);
    }

    static void deleteData() {
        System.out.print("Masukkan id yang ingin dihapus: ");
        int id = input.nextInt();
        adminController07280.deleteData(id);
    }

    static void menuPenduduk() {
        int pil;
        do {
            System.out.println("1. Insert Data penduduk");
            System.out.println("2. Update diagnosis");
            System.out.println("3. Update NoTelp");
            System.out.println("4. Lihat Data");
            System.out.println("5. Lihat Data Berdasarkan id");
            System.out.println("6. Cek Data");
            System.out.println("0. Log Out");
            System.out.print("Pilih: ");
            pil = input.nextInt();
            input.nextLine();
            switch (pil) {
                case 1:
                    insertPenduduk();
                    break;
                case 2:
                    updatediagnosis();
                    break;
                case 3:
                    updatenotelpPenduduk();
                    break;
                case 4:
                    showData();
                    break;
                case 5:
                    System.out.println("Masukkan ID: ");
                    int id = input.nextInt();
                    showData(id);
                    break;
                case 6:
                    CekData();
                    break;
            }
        } while (pil != 0);
    }

    static void insertPenduduk() {
        System.out.println("Masukkan NIP: ");
        String nip = input.nextLine();
        System.out.println("Masukkan Nama: ");
        String nama = input.nextLine();
        System.out.println("Masukkan Alamat: ");
        String alamat = input.nextLine();
        System.out.println("Masukkan No Telp: ");
        String noTelp = input.nextLine();
        System.out.print("Masukkan dagnosa: ");
        String diagnosis = input.nextLine();
        System.out.print("Masukkan Keluhan Penyakit: ");
        String klhn_penyakit = input.next();

        pendudukController07280.insertData(nip, nama, alamat, noTelp, diagnosis, klhn_penyakit);
    }

    static void updatediagnosis() {
        System.out.print("Masukkan id: ");
        int id = input.nextInt();
        System.out.print("Masukkan diagnosis baru: ");
        String diagnosis = input.next();
        pendudukController07280.updatediagnosis(diagnosis, id);
    }

    static void updatenotelpPenduduk() {
        String noTelp;
        int id;
        System.out.println("Masukkan id: ");
        id = input.nextInt();
        input.nextLine();
        System.out.println("Masukkan No Telp baru: ");
        noTelp = input.nextLine();
        pendudukController07280.updateNoTelp(noTelp, id);
    }

    static void showData() {
        for (PendudukEntity07280 pendudukEntity07280 : pendudukController07280.getDataPenduduk()) {
            System.out.println("--------------------------------------------------");
            System.out.println("Id : " + pendudukEntity07280.getId());
            System.out.println("Nama : " + pendudukEntity07280.getNama());
            System.out.println("Alamat : " + pendudukEntity07280.getAlamat());
            System.out.println("No Telp : " + pendudukEntity07280.getNoTelp());
            System.out.println("NIP : " + pendudukEntity07280.getNip());
            System.out.println("Diagnosa: " + pendudukEntity07280.getdiagnosis());
            System.out.println("Keluhan Penyakit :  " + pendudukEntity07280.getklhn_penyakit());
            System.out.println("--------------------------------------------------");
        }

    }

    static void showData(int id){
        for (PendudukEntity07280 pendudukEntity : pendudukController07280.getDataPenduduk(id)) {
            System.out.println("--------------------------------------------------");
            System.out.println("Id : " + pendudukEntity.getId());
            System.out.println("Nama : " + pendudukEntity.getNama());
            System.out.println("Alamat : " + pendudukEntity.getAlamat());
            System.out.println("No Telp : " + pendudukEntity.getNoTelp());
            System.out.println("NIP : " + pendudukEntity.getNip());
            System.out.println("diagnosis: " + pendudukEntity.getdiagnosis());
            System.out.println("Keluhan Penyakit :  " + pendudukEntity.getklhn_penyakit());
            System.out.println("--------------------------------------------------");
        }
    }


    static void CekData(){
        System.out.print("Masukkan nip yang ingin di cek: ");
        String nip = input.nextLine();
        int cek = pendudukController07280.CekData(nip);

        if(cek > 0){
            System.out.println("Data Tersedia");
            showData(cek);
        }else{
            System.out.println("Data Tidak Tersedia");
        }

    }
}
