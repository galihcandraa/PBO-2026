package model.pesanan;

import model.makanan.Makanan;
import model.pelanggan.Pelanggan;

public class Pesanan {
    private static int counter = 0;

    private int idPesanan;
    private Pelanggan pelanggan;
    private Makanan[] items = new Makanan[0];
    private String status = "BARU";
    private int waktuMasuk;
    private double total;

    public Pesanan(Pelanggan pelanggan) {
        this.idPesanan = ++counter;
        this.pelanggan = pelanggan;
    }

    public void tambahItem(Makanan m) {
        Makanan[] baru = new Makanan[items.length + 1];
        for (int i = 0; i < items.length; i++)
            baru[i] = items[i];
        baru[items.length] = m;
        items = baru;
        hitungTotal();
    }

    public void hapusItem(Makanan m) {
        int indeks = -1;
        for (int i = 0; i < items.length; i++) {
            if (items[i] == m) {
                indeks = i;
                break;
            }
        }
        if (indeks == -1)
            return;
        Makanan[] baru = new Makanan[items.length - 1];
        for (int i = 0, j = 0; i < items.length; i++) {
            if (i != indeks)
                baru[j++] = items[i];
        }
        items = baru;
        hitungTotal();
    }

    public double hitungTotal() {
        total = 0;
        for (Makanan m : items)
            total += m.hitungHarga();
        return total;
    }

    public void setStatus(String s) {
        status = s;
    }

    public int getIdPesanan() {
        return idPesanan;
    }

    public Pelanggan getPelanggan() {
        return pelanggan;
    }

    public Makanan[] getItems() {
        return items;
    }

    public String getStatus() {
        return status;
    }

    public int getWaktuMasuk() {
        return waktuMasuk;
    }

    public void setWaktuMasuk(int w) {
        waktuMasuk = w;
    }

    public double getTotal() {
        return total;
    }
}
