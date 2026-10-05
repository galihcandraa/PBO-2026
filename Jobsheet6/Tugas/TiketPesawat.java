package Jobsheet6.Tugas;

public class TiketPesawat extends Tiket {
    protected String maskapai;
    protected int beratBagasi;

    public TiketPesawat() {
    }

    public TiketPesawat(String kodeTiket, String namaPenumpang, String asal, String tujuan, int hargaDasar,
            String maskapai, int beratBagasi) {
        super(kodeTiket, namaPenumpang, asal, tujuan, hargaDasar);
        this.maskapai = maskapai;
        this.beratBagasi = beratBagasi;
    }

    public int hitungBiayaBagasi() {
        if (beratBagasi <= 20) {
            return 0;
        } else {
            return (beratBagasi - 20) * 50000;
        }
    }

    public void tampilPesawat() {
        super.tampilTiket();
        System.out.println("Maskapai        : " + maskapai);
        System.out.println("Berat Bagasi    : " + beratBagasi + " kg");
        System.out.println("Biaya Bagasi    : Rp. " + hitungBiayaBagasi() );
    }
}
