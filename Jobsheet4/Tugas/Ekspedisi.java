package Jobsheet4.Tugas;

public class Ekspedisi {
    private String nama;
    private int ongkir;
    private int totOngkir;

    public Ekspedisi(String nama, int ongkir) {
        this.nama = nama;
        this.ongkir = ongkir;
    }

    public void hitungOngkir(int beratKg) {
        totOngkir = ongkir * beratKg;
    }

    public void info() {
        System.out.println("Nama ekspedisi: " + nama);
        System.out.println("Ongkir pokok: " + ongkir);
        System.out.println("Total ongkir: " + totOngkir);
    }
}
