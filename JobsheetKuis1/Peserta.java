package JobsheetKuis1;

public class Peserta extends Pengguna {
    private Kursus[] kursusDiikuti;

    public Peserta(String nama, String email) {
        super(nama, email);
        kursusDiikuti = new Kursus[10];
    }

    public void daftarKursus(Kursus kursus) {
        for (int i = 0; i < kursusDiikuti.length; i++) {
            if (kursusDiikuti[i] == null) {
                kursusDiikuti[i] = kursus;
                break;
            }
        }
    }

    public void bayarKursus(Pembayaran bayar) {
        bayar.info();
        System.out.println("Jumlah total yang harus dibayar: Rp. " + bayar.hitungTotal() + "\n");
    }

    public void konfirmPembayaran(Pembayaran bayar) {
        bayar.setStatus("Sudah dibayar");
        bayarKursus(bayar);
    }

    @Override
    public void info() {
        super.info();
        System.out.println("Kursus yang diikuti: \n");
        for (int i = 0; i < kursusDiikuti.length; i++) {
            if (kursusDiikuti[i] != null) {
                System.out.println("Kursus " + (i + 1));
                kursusDiikuti[i].info();
                System.out.println();
            }
        }
    }
}
