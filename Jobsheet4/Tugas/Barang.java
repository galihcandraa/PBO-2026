package Jobsheet4.Tugas;

public class Barang {
    private String nama;
    private float harga;

    public Barang() {
    }
    
    public Barang(String nama, float harga) {
        this.nama = nama;
        this.harga = harga;
    }
    
    public void setBarang(Barang barang) {
        this.nama = barang.getNama();
        this.harga = barang.getHarga();
    }
    
        public String getNama() {
            return nama;
        }
    
        public float getHarga() {
            return harga;
        }

    public void info() {
        System.out.println("Nama barang: " + nama);
        System.out.println("Harga barang: " + harga);
    }
}
