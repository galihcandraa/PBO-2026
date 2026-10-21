package model.pembayaran;

public class PembayaranQRIS implements Pembayaran {
    private String idTransaksi;

    public PembayaranQRIS(String idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    @Override
    public boolean bayar(double jumlah) {
        return jumlah >= 0 && idTransaksi != null;
    }

    @Override
    public String getMetode() {
        return "QRIS (" + idTransaksi + ")";
    }
}
