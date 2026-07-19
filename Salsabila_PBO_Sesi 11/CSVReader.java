import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {
    public static void main(String[] args) {
        String csvFile = "Students.csv";
        int totalBaris = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while (br.readLine() != null) {
                totalBaris++;
            }
            System.out.println("Total baris dalam file: " + totalBaris);
        } catch (IOException e) {
            System.out.println("File tidak ditemukan. Pastikan students.csv sudah dibuat.");
        }
    }
}