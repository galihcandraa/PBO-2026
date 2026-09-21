package Jobsheet4.Tugas;

public class MainTugas15 {
    public static void main(String[] args) {
        Barang barang1 = new Barang("Sepatu", 150000);
        Barang barang2 = new Barang("Sandal", 25000);
        Barang barang3 = new Barang("Jaket", 200000);
        barang1.info();
        System.out.println();
        
        Toko toko = new Toko("Maju Makmur", 10);
        toko.setBarang(barang1, 1);
        toko.setBarang(barang2, 2);
        toko.setBarang(barang3, 3);
        toko.info();
        System.out.println();
        
        Ekspedisi ekspedisi = new Ekspedisi("JNT", 8000);
        
        Pembeli pembeli = new Pembeli("Naufal");
        pembeli.setBarang(barang3);
        pembeli.info();
        pembeli.checkout(ekspedisi, 5);
    }
}
