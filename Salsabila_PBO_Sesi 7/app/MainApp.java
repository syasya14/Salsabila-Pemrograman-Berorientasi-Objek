package app;

import java.util.Scanner;
import model.Mahasiswa;
import service.GenericManager;

public class MainApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        GenericManager<Mahasiswa<String, String, String>> manager = new GenericManager<>();

        boolean berjalan = true;
        
        System.out.println("=== APLIKASI DATA MAHASISWA (PBO GENERIC) ===");
        
        while (berjalan) {
            System.out.println("\nMenu:");
            System.out.println("1. Tambah Data Mahasiswa");
            System.out.println("2. Lihat Semua Data");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu: ");
            
            int pilihan = input.nextInt();
            input.nextLine(); // membersihkan buffer

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan NIM: ");
                    String nim = input.nextLine();
                    System.out.print("Masukkan Nama: ");
                    String nama = input.nextLine();
                    System.out.print("Masukkan Kelas: ");
                    String kelas = input.nextLine();
                    
                    // Membuat Object dan menambahkannya ke Generic Collection
                    manager.add(new Mahasiswa<>(nim, nama, kelas));
                    System.out.println("Data berhasil ditambahkan!");
                    break;
                case 2:
                    System.out.println("\n--- Daftar Mahasiswa ---");
                    manager.displayAll();
                    break;
                case 3:
                    berjalan = false;
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
        input.close();
    }
}