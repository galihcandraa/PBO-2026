package JobsheetKuis1;
import java.util.Scanner;

public class EduTechMain {

    public static void printMenu() {
        System.out.println("===== Menu Education Technology =====");
        System.out.println("1. Lihat Kursus");
        System.out.println("2. Lihat Konten");
        System.out.println("3. Lihat Instruktur");
        System.out.println("4. Lihat Peserta");
        System.out.println("5. Cek Pembayaran");
        System.out.println("6. Konfirmasi Pembayaran");
        System.out.println("0. Keluar");
        System.out.print("Masukkan pilihan (1-6): ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // membuat objek instruktur
        Instruktur budi = new Instruktur("Budi Santoso", "budi@edutech.id", "Pemrograman Java");
        Instruktur sinta = new Instruktur("Sinta Wulandari", "sinta@edutech.id", "UI/UX Design");

        // instruktur membuat konten
        Konten videoJava = new Video("Pengenalan OOP di Java", 25, "1080p");
        Konten artikelJava = new Artikel("Konsep Class dan Object", 10, 850);
        Konten kuisJava = new Kuis("Kuis Dasar OOP", 15, 10);
        Konten videoDesain = new Video("Prinsip Dasar UI Design", 30, "1440p");
        budi.buatKonten(videoJava);
        budi.buatKonten(artikelJava);
        budi.buatKonten(kuisJava);
        sinta.buatKonten(videoDesain);

        // membuat kursus dan menambahkan konten
        Kursus kursusJava = new Kursus("Java untuk Pemula", 150000);
        kursusJava.tambahKonten(videoJava);
        kursusJava.tambahKonten(artikelJava);
        kursusJava.tambahKonten(kuisJava);

        Kursus kursusDesain = new Kursus("Dasar UI/UX Design", 200000);
        kursusDesain.tambahKonten(videoDesain);

        // peserta mendaftar kursus
        Peserta andi = new Peserta("Andi Pratama", "andi@mail.com");
        andi.daftarKursus(kursusJava);
        andi.daftarKursus(kursusDesain);

        Peserta rani = new Peserta("Rani Oktavia", "rani@mail.com");
        rani.daftarKursus(kursusJava);

        // membuat pembayaran
        Pembayaran bayarAndi = new TransferBank(kursusJava.getHarga(), kursusJava, "1234567890");
        Pembayaran bayarRani = new EWallet(kursusDesain.getHarga(), kursusDesain, "081234567890");

        int pilMenu;
        do {
            printMenu();
            pilMenu = sc.nextInt();
            sc.nextLine();

            switch (pilMenu) {
                case 1:
                    System.out.println("\n=== Kursus Lengkap ===");
                    Kursus[] semuaKursus = { kursusDesain, kursusJava };
                    for (Kursus k : semuaKursus) {
                        k.info();
                        System.out.println("Total durasi konten: " + k.hitungTotalDurasi() + " menit\n");
                    }
                    break;

                case 2:
                    System.out.println("\n=== Konten Lengkap ===");
                    Konten[] semuaKonten = { videoJava, artikelJava, kuisJava, videoDesain };
                    System.out.println("------------------------------------------");
                    System.out.printf("| %-30s| %-6s |\n", "Judul", "Durasi");
                    for (Konten k : semuaKonten) {
                        System.out.println("------------------------------------------");
                        k.info();
                    }
                    System.out.println("------------------------------------------\n");
                    break;

                case 3:
                    System.out.println("\n=== Instruktur Lengkap ===");
                    budi.info();
                    sinta.info();
                    break;

                case 4:
                    System.out.println("\n=== Peserta Lengkap ===");
                    System.out.println("Peserta 1");
                    andi.info();
                    System.out.println("Peserta 2");
                    rani.info();
                    break;

                case 5:
                    System.out.println("\n=== Cek Pembayaran ===");
                    andi.bayarKursus(bayarAndi);
                    rani.bayarKursus(bayarRani);
                    break;

                case 6:
                    System.out.println("\n=== Konfirmasi Pembayaran ===");
                    andi.konfirmPembayaran(bayarAndi);
                    rani.konfirmPembayaran(bayarRani);
                    break;

                case 0:
                    System.out.println("Keluar.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid!");
                    break;
            }
        } while (pilMenu != 0);

        sc.close();
    }
}
