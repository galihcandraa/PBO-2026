package Jobsheet4.Tugas;

public class Pembeli {
    private String nama;
    private Barang barangDibeli;

    public Pembeli(String nama) {
        this.nama = nama;
    }

    public void setBarang(Barang barang) {
        barangDibeli = barang;
    }

    public void checkout(Ekspedisi kurir, int beratKg) {
        kurir.hitungOngkir(beratKg);
        kurir.info();
    }

    public void info() {
        System.out.println("Nama pembeli: " + nama);
        System.out.println("Barang dibeli: " + barangDibeli.getNama());
        System.out.println("Harga barang: " + barangDibeli.getHarga());
    }
}
