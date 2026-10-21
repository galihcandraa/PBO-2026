package model.restoran;

import model.inventori.Bahan;
import model.inventori.Inventori;
import model.karyawan.Karyawan;
import model.karyawan.Kasir;
import model.karyawan.Koki;
import model.karyawan.Pelayan;
import model.makanan.Makanan;
import model.pelanggan.Pelanggan;
import model.pembayaran.Pembayaran;
import model.pembayaran.PembayaranQRIS;
import model.pembayaran.PembayaranTunai;
import model.pesanan.Pesanan;

public class Restoran {
    private String nama;
    private double uang;
    private double reputasi = 50;
    private Inventori inventori;
    private Makanan[] menu;
    private Karyawan[] karyawan;
    private Pesanan[] antrianPesanan = new Pesanan[0];
    private Pesanan[] pesananSelesai = new Pesanan[0];

    public Restoran(String nama, double uang, Inventori inventori, Makanan[] menu, Karyawan[] karyawan) {
        this.nama = nama;
        this.uang = uang;
        this.inventori = inventori;
        this.menu = menu;
        this.karyawan = karyawan;
    }

    public void terimaPelanggan(Pelanggan p) {
        Pelayan pelayan = cari(Pelayan.class);
        if (pelayan != null)
            pelayan.layani(p);
        tambahAntrian(buatPesanan(p));
    }

    public Pesanan buatPesanan(Pelanggan p) {
        return p.pesan(menu);
    }

    private void tambahAntrian(Pesanan pesanan) {
        Pesanan[] baru = new Pesanan[antrianPesanan.length + 1];
        for (int i = 0; i < antrianPesanan.length; i++)
            baru[i] = antrianPesanan[i];
        baru[antrianPesanan.length] = pesanan;
        antrianPesanan = baru;
    }

    private void hapusDariAntrian(Pesanan target) {
        int indeks = -1;
        for (int i = 0; i < antrianPesanan.length; i++) {
            if (antrianPesanan[i] == target) {
                indeks = i;
                break;
            }
        }
        if (indeks == -1)
            return;
        Pesanan[] baru = new Pesanan[antrianPesanan.length - 1];
        for (int i = 0, j = 0; i < antrianPesanan.length; i++) {
            if (i != indeks)
                baru[j++] = antrianPesanan[i];
        }
        antrianPesanan = baru;
    }

    private void tambahPesananSelesai(Pesanan pesanan) {
        Pesanan[] baru = new Pesanan[pesananSelesai.length + 1];
        for (int i = 0; i < pesananSelesai.length; i++)
            baru[i] = pesananSelesai[i];
        baru[pesananSelesai.length] = pesanan;
        pesananSelesai = baru;
    }

    public void prosesPesanan(Pesanan ps) {
        if (ps == null)
            return;
        Koki koki = cari(Koki.class);
        Kasir kasir = cari(Kasir.class);
        Pelanggan p = ps.getPelanggan();
        hapusDariAntrian(ps);

        boolean bisa = koki != null && kasir != null;
        for (Makanan m : ps.getItems())
            if (!inventori.cekStok(m))
                bisa = false;
        if (!bisa) {
            ps.setStatus("DIBATALKAN");
            p.setKepuasan(0);
            System.out.println("Pesanan #" + ps.getIdPesanan() + " DIBATALKAN (bahan/karyawan tidak tersedia)");
            return;
        }

        ps.setStatus("DIPROSES");
        for (Makanan m : ps.getItems()) {
            koki.masak(m);
            inventori.pakaiBahan(m);
            for (int i = 0; i < m.getWaktuMasak(); i++)
                p.tunggu();
        }
        Pelayan pelayan = cari(Pelayan.class);
        if (pelayan != null)
            pelayan.layani(p, ps);

        Pembayaran pb = (ps.getIdPesanan() % 2 == 0)
                ? new PembayaranTunai(Math.ceil(ps.getTotal() / 10000) * 10000)
                : new PembayaranQRIS("TRX-" + ps.getIdPesanan());
        if (kasir.prosesBayar(ps, pb)) {
            uang += ps.getTotal();
            ps.setStatus("SELESAI");
            p.hitungKepuasan();
            tambahPesananSelesai(ps);
            System.out.printf("Pesanan #%d SELESAI, bayar %s Rp%.0f, rating %d%n",
                    ps.getIdPesanan(), pb.getMetode(), ps.getTotal(), p.beriRating());
        } else {
            ps.setStatus("GAGAL_BAYAR");
            p.setKepuasan(0);
        }
        perbaruiReputasi();
    }

    public void perbaruiReputasi() {
        if (pesananSelesai.length == 0)
            return;
        double sum = 0;
        for (Pesanan ps : pesananSelesai)
            sum += ps.getPelanggan().getKepuasan();
        reputasi = sum / pesananSelesai.length;
    }

    public void tampilkanLaporan() {
        System.out.println("===== LAPORAN " + nama + " =====");
        System.out.printf("Uang            : Rp%.0f%n", uang);
        System.out.printf("Reputasi        : %.1f / 100%n", reputasi);
        System.out.println("Pesanan selesai : " + pesananSelesai.length);
        System.out.println("Antrian         : " + antrianPesanan.length);
        System.out.println("Stok bahan:");
        for (Bahan b : inventori.getDaftarBahan())
            System.out.println("  - " + b.getNama() + ": " + b.getStok() + " " + b.getSatuan());
    }

    private <T extends Karyawan> T cari(Class<T> tipe) {
        for (Karyawan k : karyawan) {
            if (tipe.isInstance(k) && k.isTersedia())
                return tipe.cast(k);
        }
        return null;
    }

    public Pesanan[] getAntrianPesanan() {
        return antrianPesanan;
    }

    public Inventori getInventori() {
        return inventori;
    }
}
