package model.pelanggan;

import model.makanan.Makanan;
import model.pesanan.Pesanan;

import java.util.Random;

public class Pelanggan {
    private static final Random RNG = new Random();

    private String nama;
    private Makanan[] preferensi;
    private int tingkatKesabaran;
    private int waktuTunggu;
    private double kepuasan;

    public Pelanggan(String nama, Makanan[] preferensi, int tingkatKesabaran) {
        this.nama = nama;
        this.preferensi = preferensi;
        this.tingkatKesabaran = tingkatKesabaran;
    }

    public Pesanan pesan(Makanan[] menu) {
        Pesanan ps = new Pesanan(this);
        Makanan[] dipilih = new Makanan[0];
        for (Makanan pref : preferensi) {
            for (Makanan m : menu) {
                if (m.getNama().equals(pref.getNama())) {
                    Makanan[] baru = new Makanan[dipilih.length + 1];
                    for (int i = 0; i < dipilih.length; i++)
                        baru[i] = dipilih[i];
                    baru[dipilih.length] = m;
                    dipilih = baru;
                }
            }
        }
        if (dipilih.length == 0 && menu.length > 0) {
            dipilih = new Makanan[] { menu[RNG.nextInt(menu.length)] };
        }
        for (Makanan m : dipilih)
            ps.tambahItem(m);
        return ps;
    }

    public void tunggu() {
        waktuTunggu++;
    }

    public double hitungKepuasan() {
        int lebih = Math.max(0, waktuTunggu - tingkatKesabaran);
        kepuasan = Math.max(0, 100 - lebih * 10);
        return kepuasan;
    }

    public int beriRating() {
        return (int) Math.max(1, Math.ceil(kepuasan / 20.0));
    }

    public String getNama() {
        return nama;
    }

    public double getKepuasan() {
        return kepuasan;
    }

    public void setKepuasan(double k) {
        kepuasan = k;
    }

    public int getWaktuTunggu() {
        return waktuTunggu;
    }
}
