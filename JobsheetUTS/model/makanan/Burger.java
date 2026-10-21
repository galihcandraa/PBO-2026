package model.makanan;

import model.inventori.Bahan;

public class Burger extends Makanan {
    private String jenisRoti;
    private int jumlahPatty;

    public Burger(String nama, double harga, Bahan[] bahan, int waktuMasak, String jenisRoti, int jumlahPatty) {
        super(nama, harga, bahan, waktuMasak);
        this.jenisRoti = jenisRoti;
        this.jumlahPatty = jumlahPatty;
    }

    @Override
    public String getDeskripsi() {
        return nama + " - roti " + jenisRoti + ", " + jumlahPatty + " patty";
    }

    @Override
    public double hitungHarga() {
        return harga + (jumlahPatty - 1) * 8000;
    } 
}
