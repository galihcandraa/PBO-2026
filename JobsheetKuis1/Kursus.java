package JobsheetKuis1;

public class Kursus {
    private String nama;
    private double harga;
    private Konten[] daftarKonten;

    public Kursus(String nama, double harga) {
        this.nama = nama;
        this.harga = harga;
        this.daftarKonten = new Konten[10];
    }

    public void tambahKonten(Konten konten) {
        for (int i = 0; i < daftarKonten.length; i++) {
            if (daftarKonten[i] == null) {
                daftarKonten[i] = konten;
                break;
            }
        }
    }

    public String getNama() {
        return this.nama;
    }

    public double getHarga() {
        return this.harga;
    }

    public int hitungTotalDurasi() {
        int total = 0;
        for (int i = 0; i < daftarKonten.length; i++) {
            if (daftarKonten[i] == null) {
                break;
            }
            total += daftarKonten[i].durasi;
        }
        return total;
    }

    public void info() {
        System.out.println("Judul         : " + this.nama);
        System.out.println("Harga         : Rp. " + this.harga);
        System.out.println("Daftar Konten : ");
        System.out.println("------------------------------------------");
        System.out.printf("| %-30s| %-6s |\n", "Judul", "Durasi");
        System.out.println("------------------------------------------");
        for (int i = 0; i < daftarKonten.length; i++) {
            if (daftarKonten[i] != null) {
                daftarKonten[i].info();
                System.out.println("------------------------------------------");
            }
        }
    }
}
