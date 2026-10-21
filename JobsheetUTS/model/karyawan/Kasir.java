package model.karyawan;

import model.pembayaran.Pembayaran;
import model.pesanan.Pesanan;

public class Kasir extends Karyawan {
    private String shift;

    public Kasir(String nama, int skill, double gaji, String shift) {
        super(nama, skill, gaji);
        this.shift = shift;
    }

    @Override
    public void kerja() {
        System.out.println(nama + " (Kasir, shift " + shift + ") di kasir");
    }

    public boolean prosesBayar(Pesanan ps, Pembayaran pb) {
        return pb.bayar(ps.getTotal());
    }

    public boolean prosesBayar(Pesanan ps, Pembayaran pb, double diskon) {
        return pb.bayar(ps.getTotal() * (1 - diskon / 100.0));
    }
}
