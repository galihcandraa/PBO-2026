package Jobsheet1.kode;

public class Mouse extends InputDevice {
    private int dpi;
    private int jumlahTombol;

    public Mouse(String merk, boolean statusKoneksi, String jenisKoneksi, int dpi, int jumlahTombol) {
        super(merk, statusKoneksi, jenisKoneksi);
        this.dpi = dpi;
        this.jumlahTombol = jumlahTombol;
    }

    public void klikKiri() {
        System.out.println("Berhasil mengklik kiri");
    }

    public void ubahDpi(int angka) {
        dpi = angka;
    }

    @Override
    public void tampilInfo() {
        super.tampilInfo();
        System.out.println("DPI: " + dpi);
        System.out.println("Jumlah Tombol: " + jumlahTombol);
    }
}
