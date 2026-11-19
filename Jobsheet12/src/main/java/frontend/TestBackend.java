package frontend;

import backend.*;

public class TestBackend {

    public static void main(String[] args) {
        Anggota anggota1 = new Anggota().getById(1);
        Anggota anggota2 = new Anggota().getById(2);

        Buku buku1 = new Buku().getById(1);
        Buku buku2 = new Buku().getById(2);

        Peminjaman peminjaman1 = new Peminjaman(anggota1, buku1, "2026-11-19", "2026-11-26");
        Peminjaman peminjaman2 = new Peminjaman(anggota2, buku2, "2026-11-19", "2026-11-25");
        Peminjaman peminjaman3 = new Peminjaman(anggota1, buku2, "2026-11-20", "2026-11-27");

        peminjaman1.save();
        peminjaman2.save();
        peminjaman3.save();

        peminjaman2.setTanggalKembali("2026-11-30");
        peminjaman2.save();

        peminjaman3.delete();

        System.out.println("=== Semua Data Peminjaman ===");
        for (Peminjaman p : new Peminjaman().getAll()) {
            System.out.println("Anggota: " + p.getAnggota().getNama()
                    + ", Buku: " + p.getBuku().getJudul()
                    + ", Tgl Pinjam: " + p.getTanggalPinjam()
                    + ", Tgl Kembali: " + p.getTanggalKembali());
        }

        System.out.println("\n=== Hasil Pencarian ===");
        for (Peminjaman p : new Peminjaman().search("Timun")) {
            System.out.println("Anggota: " + p.getAnggota().getNama()
                    + ", Buku: " + p.getBuku().getJudul()
                    + ", Tgl Pinjam: " + p.getTanggalPinjam()
                    + ", Tgl Kembali: " + p.getTanggalKembali());
        }

//        Kategori novel = new Kategori().getById(1);
//        Kategori referensi = new Kategori().getById(2);
//
//        Buku buku1 = new Buku(novel, "Timun Mas", "Elex Media", "Bang Supit");
//        Buku buku2 = new Buku(referensi, "Metode Linier", "Springer", "Alex Baldwin");
//        Buku buku3 = new Buku(novel, "Bintang Terang", "Erlangga", "Mat Sewoot");
//
//        buku1.save();
//        buku2.save();
//
//        buku2.setJudul("Aljabar Linier");
//        buku2.save();
//
//        buku3.delete();
//
//        for (Buku b : new Buku().getAll()) {
//            System.out.println("Kategori: " + b.getKategori().getNama() + ", Judul: " + b.getJudul());
//        }
//
//        for (Buku b : new Buku().search("timun")) {
//            System.out.println("Kategori: " + b.getKategori().getNama() + ", Judul: " + b.getJudul());
//        }
//        Anggota anggota1 = new Anggota("Budi", "Suhat", "0801");
//        Anggota anggota2 = new Anggota("Agus", "Suhat", "0802");
//        Anggota anggota3 = new Anggota("Eko", "Dioyo", "0803");
//
//        anggota1.save();
//        anggota2.save();
//        anggota3.save();
//
//        anggota2.setAlamat("Dinoyo");
//        anggota2.save();
//
//        anggota3.delete();
//
//        for (Anggota a : new Anggota().getAll()) {
//            System.out.println("Nama: " + a.getNama() + ", Alamat: " + a.getAlamat() + ", Telepon: " + a.getTelepon());
//        }
//
//        for (Anggota a : new Anggota().search("ilmiah")) {
//            System.out.println("Nama: " + a.getNama() + ", Alamat: " + a.getAlamat() + ", Telepon: " + a.getTelepon());
//        }
        //        Kategori kat1 = new Kategori("Novel", "Koleksi Buku Novel");
//        Kategori kat2 = new Kategori("Referensi", "Buku Referensi Ilmiah");
//        Kategori kat3 = new Kategori("Komik", "Komik Anak-Anak");
//
//        kat1.save();
//        kat2.save();
//        kat3.save();
//
//        kat2.setKeterangan("Koleksi buku referensi ilmiah");
//        kat2.save();
//
//        kat3.delete();
//
//        for (Kategori k : new Kategori().getAll()) {
//            System.out.println("Nama: " + k.getNama() + ", Ket: " + k.getKeterangan());
//        }
//
//        for (Kategori k : new Kategori().search("ilmiah")) {
//            System.out.println("Nama: " + k.getNama() + ", Ket: " + k.getKeterangan());
//        }
    }
}
