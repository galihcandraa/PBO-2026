package model.inventori;

import model.makanan.Makanan;

public class Inventori {
    private Bahan[] daftarBahan;

    public Inventori(Bahan[] bahan) {
        daftarBahan = bahan;
    }

    private Bahan cari(String nama) {
        for (Bahan b : daftarBahan) {
            if (b.getNama().equalsIgnoreCase(nama))
                return b;
        }
        return null;
    }

    public boolean cekStok(String nama, int jumlah) {
        Bahan b = cari(nama);
        return b != null && b.cukup(jumlah);
    }

    public boolean cekStok(Makanan m) {
        for (Bahan resep : m.getBahan()) {
            if (!cekStok(resep.getNama(), resep.getStok()))
                return false;
        }
        return true;
    }

    public void pakaiBahan(Makanan m) {
        for (Bahan resep : m.getBahan()) {
            Bahan b = cari(resep.getNama());
            if (b != null)
                b.kurangiStok(resep.getStok());
        }
    }

    public void restock(String nama, int jumlah) {
        Bahan b = cari(nama);
        if (b != null)
            b.tambahStok(jumlah);
    }

    public Bahan[] getDaftarBahan() {
        return daftarBahan;
    }
}
