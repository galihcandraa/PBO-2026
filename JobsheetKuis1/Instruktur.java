package JobsheetKuis1;

public class Instruktur extends Pengguna {
    private String bidang;
    private Konten[] daftarKonten;

    public Instruktur(String nama, String email, String bidang) {
        super(nama, email);
        this.bidang = bidang;
        daftarKonten = new Konten[10];
    }

    public void buatKonten(Konten konten) {
        for (int i = 0; i < daftarKonten.length; i++) {
            if (daftarKonten[i] == null) {
                daftarKonten[i] = konten;
                break;
            }
        }
    }

    @Override
    public void info() {
        super.info();
        System.out.println("Bidang   : " + bidang);
        System.out.println("Daftar konten yang dibuat: ");
        System.out.println("------------------------------------------");
        System.out.printf("| %-30s| %-6s |\n", "Judul", "Durasi");

        for (int i = 0; i < daftarKonten.length; i++) {
            if (daftarKonten[i] != null) {
                System.out.println("------------------------------------------");
                daftarKonten[i].info();
            }
        }
        System.out.println("------------------------------------------\n");
    }
}
