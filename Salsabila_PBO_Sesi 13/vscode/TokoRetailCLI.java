import java.sql.*;
import java.util.Scanner;

public class TokoRetailCLI {
    // Sesuaikan dengan konfigurasi database Anda
    static final String URL = "jdbc:mysql://localhost:3306/toko_retail";
    static final String USER = "root";
    static final String PASS = "";
    
    static Connection conn;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            conn = DriverManager.getConnection(URL, USER, PASS);
            int pilihan;
            
            do {
                System.out.println("\n=======================");
                System.out.println("   MENU TOKO RETAIL   ");
                System.out.println("=======================");
                System.out.println("1. Tampil Semua Data");
                System.out.println("2. Tambah Data");
                System.out.println("3. Cari Data");
                System.out.println("4. Ubah Data");
                System.out.println("5. Hapus Data");
                System.out.println("0. Keluar");
                System.out.print("Pilihan : ");
                pilihan = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (pilihan) {
                    case 1: tampilData(); break;
                    case 2: tambahData(); break;
                    case 3: cariData(); break;
                    case 4: ubahData(); break;
                    case 5: hapusData(); break;
                    case 0: System.out.println("Terima kasih!"); break;
                    default: System.out.println("Pilihan tidak valid!");
                }
            } while (pilihan != 0);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 1. TAMPIL DATA (Menu 1)
    static void tampilData() throws SQLException {
        String sql = "SELECT * FROM barang";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        System.out.println("\n-----------------------------------------------------");
        System.out.printf("| %-2s | %-6s | %-20s | %-8s | %-4s |\n", "#", "Kode", "Nama Barang", "Harga", "Stok");
        System.out.println("-----------------------------------------------------");
        
        int no = 1;
        while (rs.next()) {
            System.out.printf("| %-2d | %-6s | %-20s | %-8d | %-4d |\n", 
                    no++, 
                    rs.getString("kode"), 
                    rs.getString("nama_barang"), 
                    rs.getInt("harga"), 
                    rs.getInt("stok"));
        }
        System.out.println("-----------------------------------------------------");
        System.out.println("Total: " + (no-1) + " barang");
    }

    // 2. TAMBAH DATA (Menu 2)
    static void tambahData() throws SQLException {
        System.out.print("Masukkan Kode Barang: ");
        String kode = scanner.nextLine();
        System.out.print("Masukkan Nama Barang: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan Harga: ");
        int harga = scanner.nextInt();
        System.out.print("Masukkan Stok: ");
        int stok = scanner.nextInt();

        String sql = "INSERT INTO barang (kode, nama_barang, harga, stok) VALUES (?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, kode);
        pstmt.setString(2, nama);
        pstmt.setInt(3, harga);
        pstmt.setInt(4, stok);
        
        if (pstmt.executeUpdate() > 0) {
            System.out.println("Data berhasil ditambahkan!");
        }
    }

    // 3. CARI DATA (Menu 3)
    static void cariData() throws SQLException {
        System.out.print("Masukkan Nama Barang yang dicari: ");
        String keyword = scanner.nextLine();

        String sql = "SELECT * FROM barang WHERE nama_barang LIKE ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, "%" + keyword + "%");
        ResultSet rs = pstmt.executeQuery();

        System.out.println("\nHasil Pencarian:");
        while (rs.next()) {
            System.out.printf("Kode: %s | %s | Harga: %d | Stok: %d\n", 
                    rs.getString("kode"), rs.getString("nama_barang"), rs.getInt("harga"), rs.getInt("stok"));
        }
    }

    // 4. UBAH DATA (Menu 4)
    static void ubahData() throws SQLException {
        System.out.print("Masukkan Kode Barang yang akan diubah: ");
        String kode = scanner.nextLine();
        
        System.out.print("Nama Baru: ");
        String nama = scanner.nextLine();
        System.out.print("Harga Baru: ");
        int harga = scanner.nextInt();
        System.out.print("Stok Baru: ");
        int stok = scanner.nextInt();

        String sql = "UPDATE barang SET nama_barang = ?, harga = ?, stok = ? WHERE kode = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, nama);
        pstmt.setInt(2, harga);
        pstmt.setInt(3, stok);
        pstmt.setString(4, kode);

        if (pstmt.executeUpdate() > 0) {
            System.out.println("Data berhasil diperbarui!");
        } else {
            System.out.println("Barang dengan kode tersebut tidak ditemukan.");
        }
    }

    // 5. HAPUS DATA (Menu 5)
    static void hapusData() throws SQLException {
        System.out.print("Masukkan Kode Barang yang akan dihapus: ");
        String kode = scanner.nextLine();

        String sql = "DELETE FROM barang WHERE kode = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, kode);

        if (pstmt.executeUpdate() > 0) {
            System.out.println("Data berhasil dihapus!");
        } else {
            System.out.println("Barang tidak ditemukan.");
        }
    }
}