package model.makanan;

import model.inventori.Bahan;

public abstract class Makanan {
    protected String nama;
    protected double harga;
    protected Bahan[] bahan;
    protected int waktuMasak;

    public Makanan(String nama, double harga, Bahan[] bahan, int waktuMasak) {
        this.nama = nama;
        this.harga = harga;
        this.bahan = bahan;
        this.waktuMasak = waktuMasak;
    }

    public abstract String getDeskripsi();

    public double hitungHarga() {
        return harga;
    }

    public double hitungHarga(double diskon) {
        return hitungHarga() * (1 - diskon / 100.0);
    }

    public void masak() {
        System.out.println("  Memasak " + nama + " (" + waktuMasak + " menit)");
    }

    public String getNama() {
        return nama;
    }

    public Bahan[] getBahan() {
        return bahan;
    }

    public int getWaktuMasak() {
        return waktuMasak;
    }
}
