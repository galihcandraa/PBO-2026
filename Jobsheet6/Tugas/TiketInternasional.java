package Jobsheet6.Tugas;

public class TiketInternasional extends TiketPesawat {
    protected String nomorPaspor;
    protected int asuransi;

    public TiketInternasional() {

    }

    public TiketInternasional(String kodeTiket, String namaPenumpang, String asal, String tujuan, int hargaDasar,
            String maskapai, int beratBagassi, String nomorPaspor, int asuransi) {
        super(kodeTiket, namaPenumpang, asal, tujuan, hargaDasar, maskapai, beratBagassi);
        this.nomorPaspor = nomorPaspor;
        this.asuransi = asuransi;
    }

    public void tampilInternasional() {
        super.tampilPesawat();
        System.out.println("Nomor Paspor    : " + nomorPaspor);
        System.out.println("Asuransi        : " + asuransi);
        System.out.println("Total Bayar     : " + (hargaDasar + hitungBiayaBagasi() + asuransi));
    }
}
