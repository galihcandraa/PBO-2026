package model.makanan;

import model.inventori.Bahan;

public class KentangGoreng extends Makanan {
    private String ukuran;
    private String bumbu;

    public KentangGoreng(String nama, double harga, Bahan[] bahan, int waktuMasak, String ukuran, String bumbu) {
        super(nama, harga, bahan, waktuMasak);
        this.ukuran = ukuran;
        this.bumbu = bumbu;
    }

    @Override
    public String getDeskripsi() {
        return nama + " - ukuran " + ukuran + ", bumbu " + bumbu;
    }

    @Override
    public double hitungHarga() {
        switch (ukuran.toLowerCase()) {
            case "besar":
                return harga * 1.5;
            case "kecil":
                return harga * 0.8;
            default:
                return harga;
        }
    }
}
