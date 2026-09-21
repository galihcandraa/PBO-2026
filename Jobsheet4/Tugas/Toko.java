package Jobsheet4.Tugas;

public class Toko {
    private String nama;
    private Barang[] arrBarang;

    public Toko(String nama, int jmlBarang) {
        this.nama = nama;
        arrBarang = new Barang[jmlBarang];
        initBarang();
    }

    private void initBarang() {
        for (int i = 0; i < arrBarang.length; i++) {
            arrBarang[i] = new Barang();
        }
    }

    public void setBarang(Barang barang, int nomor) {
        if (arrBarang[nomor - 1] != null) {
            arrBarang[nomor - 1].setBarang(barang);
        }
    }

    public void info() {
        System.out.println("Nama Toko: " + nama);
        System.out.println("Data Barang: ");
        System.out.printf("%-3s %-15s %-15s\n", "No.", "Nama Barang", "Harga");
        for (int i = 0; i < arrBarang.length; i++) {
            if (arrBarang[i].getNama() != null) {
                System.out.printf("%-3d %-15s %-15.2f\n", i + 1, arrBarang[i].getNama(), arrBarang[i].getHarga());
            }
        }
    }
}
