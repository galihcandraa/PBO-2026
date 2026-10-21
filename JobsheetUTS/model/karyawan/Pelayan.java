package model.karyawan;

import model.pelanggan.Pelanggan;
import model.pesanan.Pesanan;

public class Pelayan extends Karyawan {
    private int jumlahMeja;

    public Pelayan(String nama, int skill, double gaji, int jumlahMeja) {
        super(nama, skill, gaji);
        this.jumlahMeja = jumlahMeja;
    }

    @Override
    public void kerja() {
        System.out.println(nama + " (Pelayan) melayani " + jumlahMeja + " meja");
    }

    public void layani(Pelanggan p) {
        System.out.println("  " + nama + " menyambut " + p.getNama());
    }

    public void layani(Pelanggan p, Pesanan ps) {
        System.out.println("  " + nama + " mengantar pesanan #" + ps.getIdPesanan() + " ke " + p.getNama());
    }
}
