package model.pembayaran;

public interface Pembayaran {
    boolean bayar(double jumlah);

    String getMetode();
}
