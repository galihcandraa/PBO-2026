package Jobsheet6.Tugas;

public class TiketDomestik extends TiketPesawat {
    protected int pajakBandara;

    public TiketDomestik() {
    }

    public TiketDomestik(String kodeTiket, String namaPenumpang, String asal, String tujuan, int hargaDasar,
            String maskapai, int beratBagassi, int pajakBandara) {
        super(kodeTiket, namaPenumpang, asal, tujuan, hargaDasar, maskapai, beratBagassi);
        this.pajakBandara = pajakBandara;
    }

    public void tampilDomestik() {
        super.tampilPesawat();
        System.out.println("Pajak Bandara   : " + pajakBandara);
        System.out.println("Total Bayar     : " + (hargaDasar + hitungBiayaBagasi() + pajakBandara));
    }
}
