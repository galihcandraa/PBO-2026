import java.util.Random;
import java.util.Scanner;
import model.inventori.*;
import model.karyawan.*;
import model.makanan.*;
import model.pelanggan.*;
import model.pesanan.*;
import model.restoran.*;

public class Main {
    private static final Scanner INPUT = new Scanner(System.in);
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        Makanan[] menu = buatMenu();

        Inventori inventori = new Inventori(new Bahan[] {
                new Bahan("Roti", 20, "pcs", 3000),
                new Bahan("Daging", 30, "pcs", 8000),
                new Bahan("Keju", 20, "pcs", 2000),
                new Bahan("Kentang", 25, "porsi", 4000),
                new Bahan("Teh", 40, "sachet", 500)
        });

        Karyawan[] staf = new Karyawan[] {
                new Koki("Budi", 8, 4_000_000, "Grill"),
                new Pelayan("Sari", 6, 3_000_000, 10),
                new Kasir("Dewi", 7, 3_200_000, "Pagi"),
                new PetugasKebersihan("Joko", 5, 2_500_000, "Ruang makan")
        };

        Restoran restoran = new Restoran("Resto Simulasi", 1_000_000, inventori, menu, staf);
        int nomorPelanggan = 0;
        boolean berjalan = true;

        tampilkanPembuka("Resto Simulasi");
        while (berjalan) {
            tampilkanMenu();
            int pilihan = bacaAngka("Pilih aksi: ");

            switch (pilihan) {
                case 1:
                    nomorPelanggan++;
                    Pelanggan pelanggan = buatPelanggan(nomorPelanggan, menu);
                    restoran.terimaPelanggan(pelanggan);
                    Pesanan[] antrianBaru = restoran.getAntrianPesanan();
                    Pesanan pesananBaru = antrianBaru[antrianBaru.length - 1];
                    System.out.printf("Pesanan #%d masuk! Total: Rp%,.0f%n",
                            pesananBaru.getIdPesanan(), pesananBaru.getTotal());
                    break;
                case 2:
                    prosesPesananBerikutnya(restoran);
                    break;
                case 3:
                    tampilkanAntrian(restoran);
                    break;
                case 4:
                    tampilkanMenuMakanan(menu);
                    break;
                case 5:
                    kelolaStok(restoran.getInventori());
                    break;
                case 6:
                    tampilkanStok(restoran.getInventori());
                    break;
                case 7:
                    restoran.tampilkanLaporan();
                    break;
                case 8:
                    for (Karyawan karyawan : staf) {
                        karyawan.kerja();
                    }
                    break;
                case 0:
                    berjalan = false;
                    System.out.println("\nMenutup restoran...");
                    restoran.tampilkanLaporan();
                    System.out.println("Terima kasih sudah bermain. Sampai jumpa!");
                    break;
                default:
                    System.out.println("Pilihan tidak tersedia. Coba lagi.");
            }
        }
        INPUT.close();
    }

    private static Makanan[] buatMenu() {
        return new Makanan[] {
                new Burger("Burger Keju", 25000,
                        new Bahan[] {
                                new Bahan("Roti", 1, "pcs", 0),
                                new Bahan("Daging", 1, "pcs", 0),
                                new Bahan("Keju", 1, "pcs", 0)
                        }, 5, "Wijen", 1),
                new Burger("Burger Double", 25000,
                        new Bahan[] {
                                new Bahan("Roti", 1, "pcs", 0),
                                new Bahan("Daging", 2, "pcs", 0)
                        }, 7, "Gandum", 2),
                new KentangGoreng("Kentang Goreng", 15000,
                        new Bahan[] {
                                new Bahan("Kentang", 1, "porsi", 0)
                        }, 3, "Sedang", "Balado"),
                new Minuman("Es Teh", 8000,
                        new Bahan[] {
                                new Bahan("Teh", 1, "sachet", 0)
                        }, 1, 350, true)
        };
    }

    private static Pelanggan buatPelanggan(int nomor, Makanan[] menu) {
        Makanan pilihan = menu[RANDOM.nextInt(menu.length)];
        Makanan[] preferensi = { pilihan };
        int kesabaran = 5 + RANDOM.nextInt(20);
        return new Pelanggan("Pelanggan-" + nomor, preferensi, kesabaran);
    }

    private static void tampilkanPembuka(String namaRestoran) {
        System.out.println("========================================");
        System.out.println("          RESTAURANT MANAGER ");
        System.out.println("========================================");
        System.out.println("Selamat datang di " + namaRestoran + "!");
        System.out.println("Kelola pelanggan, pesanan, dan stok restoranmu.");
    }

    private static void tampilkanMenu() {
        System.out.println("\n--------------- MENU UTAMA -------------");
        System.out.println("1. Terima pelanggan");
        System.out.println("2. Proses pesanan berikutnya");
        System.out.println("3. Lihat antrean pesanan");
        System.out.println("4. Lihat daftar menu makanan");
        System.out.println("5. Restock bahan");
        System.out.println("6. Lihat stok bahan");
        System.out.println("7. Lihat laporan restoran");
        System.out.println("8. Lihat aktivitas karyawan");
        System.out.println("0. Tutup restoran dan keluar");
        System.out.println("-----------------------------------------");
    }

    private static void prosesPesananBerikutnya(Restoran restoran) {
        Pesanan[] antrian = restoran.getAntrianPesanan();
        if (antrian.length == 0) {
            System.out.println("Belum ada pesanan di antrean.");
            return;
        }

        Pesanan pesanan = antrian[0];
        System.out.printf("Memproses pesanan #%d milik %s...%n",
                pesanan.getIdPesanan(), pesanan.getPelanggan().getNama());
        restoran.prosesPesanan(pesanan);
    }

    private static void tampilkanAntrian(Restoran restoran) {
        Pesanan[] antrian = restoran.getAntrianPesanan();
        System.out.println("\n============== ANTREAN PESANAN ==============");
        if (antrian.length == 0) {
            System.out.println("Antrean masih kosong.");
            return;
        }

        for (Pesanan pesanan : antrian) {
            System.out.printf("#%d | %-16s | Rp%,.0f | %s%n",
                    pesanan.getIdPesanan(),
                    pesanan.getPelanggan().getNama(),
                    pesanan.getTotal(),
                    pesanan.getStatus());
            System.out.print("   Item: ");
            for (int i = 0; i < pesanan.getItems().length; i++) {
                if (i > 0)
                    System.out.print(", ");
                System.out.print(pesanan.getItems()[i].getNama());
            }
            System.out.println();
        }
        System.out.println("==============================================");
    }

    private static void tampilkanMenuMakanan(Makanan[] menu) {
        System.out.println("\n================ DAFTAR MENU ================");
        for (int i = 0; i < menu.length; i++) {
            System.out.printf("%d. %-20s Rp%,.0f%n",
                    i + 1, menu[i].getDeskripsi(), menu[i].hitungHarga());
        }
        System.out.println("==============================================");
        System.out.println("Catatan: menu pelanggan dipilih secara acak.");
    }

    private static void kelolaStok(Inventori inventori) {
        Bahan[] bahan = inventori.getDaftarBahan();
        tampilkanStok(inventori);
        System.out.print("Nama bahan yang ingin ditambah (ketik 0 untuk batal): ");
        String nama = INPUT.nextLine().trim();
        if (nama.equals("0")) {
            System.out.println("Restock dibatalkan.");
            return;
        }

        boolean ditemukan = false;
        for (Bahan item : bahan) {
            if (item.getNama().equalsIgnoreCase(nama)) {
                ditemukan = true;
                int jumlah = bacaAngka("Jumlah tambahan: ");
                if (jumlah <= 0) {
                    System.out.println("Jumlah harus lebih dari 0.");
                } else {
                    inventori.restock(item.getNama(), jumlah);
                    System.out.printf("Stok %s berhasil ditambah %d %s.%n",
                            item.getNama(), jumlah, item.getSatuan());
                }
                break;
            }
        }
        if (!ditemukan) {
            System.out.println("Bahan tidak ditemukan. Periksa nama bahan pada daftar stok.");
        }
    }

    private static void tampilkanStok(Inventori inventori) {
        System.out.println("\n================= STOK BAHAN =================");
        for (Bahan bahan : inventori.getDaftarBahan()) {
            System.out.printf("- %-10s : %d %s%n",
                    bahan.getNama(), bahan.getStok(), bahan.getSatuan());
        }
        System.out.println("===============================================");
    }

    private static int bacaAngka(String pesan) {
        while (true) {
            System.out.print(pesan);
            String input = INPUT.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Masukkan angka yang valid.");
            }
        }
    }
}
