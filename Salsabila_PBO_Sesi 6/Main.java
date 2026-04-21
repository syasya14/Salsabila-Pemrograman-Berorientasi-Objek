import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Contoh menggunakan MacBook, bisa diganti dengan new Lenovo() atau new Toshiba()
        Laptop myLaptop = new MacBook(); 
        LaptopUser andri = new LaptopUser(myLaptop);
        
        Scanner input = new Scanner(System.in);
        String action;
        boolean loop = true;

        System.out.println("=== APLIKASI INTERFACE LAPTOP ===");
        System.out.println("[ON] Nyalakan Laptop");
        System.out.println("[OFF] Matikan Laptop");
        System.out.println("[UP] Tambah Volume");
        System.out.println("[DOWN] Kurangi Volume");
        System.out.println("[EXIT] Keluar Aplikasi");
        System.out.println("---------------------------------");

        while (loop) {
            System.out.print("Pilih aksi> ");
            action = input.nextLine().toUpperCase();

            switch (action) {
                case "ON":
                    andri.turnOnLaptop();
                    break;
                case "OFF":
                    andri.turnOffLaptop();
                    break;
                case "UP":
                    andri.makeLaptopLouder();
                    break;
                case "DOWN":
                    andri.makeLaptopSilence();
                    break;
                case "EXIT":
                    System.out.println("Keluar dari program...");
                    loop = false;
                    break;
                default:
                    System.out.println("Input salah! Gunakan ON, OFF, UP, atau DOWN.");
                    break;
            }
        }
        input.close();
    }
}