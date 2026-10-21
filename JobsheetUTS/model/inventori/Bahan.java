package model.inventori;

public class Bahan {
    private String nama;
    private int stok;
    private String satuan;
    private double hargaBeli;

    public Bahan(String nama, int stok, String satuan, double hargaBeli) {
        this.nama = nama;
        this.stok = stok;
        this.satuan = satuan;
        this.hargaBeli = hargaBeli;
    }

    public void kurangiStok(int jumlah) {
        if (cukup(jumlah))
            stok -= jumlah;
    }

    public void tambahStok(int jumlah) {
        if (jumlah > 0)
            stok += jumlah;
    }

    public boolean cukup(int jumlah) {
        return stok >= jumlah;
    }

    public String getNama() {
        return nama;
    }

    public int getStok() {
        return stok;
    }

    public String getSatuan() {
        return satuan;
    }

    public double getHargaBeli() {
        return hargaBeli;
    }
}
