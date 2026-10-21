package model.pembayaran;

public class PembayaranTunai implements Pembayaran {
    private double uangDiterima;
    private double kembalian;

    public PembayaranTunai(double uangDiterima) {
        this.uangDiterima = uangDiterima;
    }

    @Override
    public boolean bayar(double jumlah) {
        if (uangDiterima < jumlah)
            return false;
        kembalian = uangDiterima - jumlah;
        return true;
    }

    public double hitungKembalian() {
        return kembalian;
    }

    @Override
    public String getMetode() {
        return "Tunai";
    }
}
