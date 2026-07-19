import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CSVWriter {
    public static void main(String[] args) {
        // Nama file harus konsisten agar terbaca oleh program lain
        String csvFile = "Students.csv"; 
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan data (NIM,NAMA,UMUR,PRODI): ");
        String inputData = scanner.nextLine();

        // Menggunakan mode 'true' agar data ditambahkan ke baris baru paling bawah [cite: 91]
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(csvFile, true))) { 
            // Menulis input dari pengguna ke file [cite: 96]
            bw.write(inputData);
            // Menambahkan baris baru setelah data ditulis agar input selanjutnya rapi [cite: 97]
            bw.newLine(); 
            
            System.out.println("Data berhasil disimpan ke " + csvFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        scanner.close();
    }
}