package model.makanan;

import model.inventori.Bahan;

public class Minuman extends Makanan {
    private int ukuranMl;
    private boolean dingin;

    public Minuman(String nama, double harga, Bahan[] bahan, int waktuMasak, int ukuranMl, boolean dingin) {
        super(nama, harga, bahan, waktuMasak);
        this.ukuranMl = ukuranMl;
        this.dingin = dingin;
    }

    @Override
    public String getDeskripsi() {
        return nama + " - " + ukuranMl + " ml, " + (dingin ? "dingin" : "panas");
    }

    @Override
    public void masak() {
        System.out.println("  Menyiapkan minuman " + nama);
    }
}
