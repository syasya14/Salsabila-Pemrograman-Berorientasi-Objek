package model;

// Konsep Generic dengan 3 parameter sesuai soal No. 1
public class Mahasiswa<T1, T2, T3> {
    private T1 nim;
    private T2 nama;
    private T3 kelas;

    public Mahasiswa(T1 nim, T2 nama, T3 kelas) {
        this.nim = nim;
        this.nama = nama;
        this.kelas = kelas;
    }

    // Encapsulation (Getter)
    public void info() {
        System.out.println("NIM: " + nim + " | Nama: " + nama + " | Kelas: " + kelas);
    }
}