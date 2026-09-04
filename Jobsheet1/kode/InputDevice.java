package Jobsheet1.kode;

public class InputDevice {
    private String merk;
    private boolean statusKoneksi;
    private String jenisKoneksi;

    
    public InputDevice(String merk, boolean statusKoneksi, String jenisKoneksi) {
        this.merk = merk;
        this.jenisKoneksi = jenisKoneksi;
    }

    public String hubungkan() {
        statusKoneksi = true;
        return "Berhasil terhubung";
    }

    public String putuskan() {
        statusKoneksi = false;
        return "Berhasil diputuskan";
    }    

    public void tampilInfo() {
        System.out.println("merk: " + merk);
        System.out.println("Status Koneksi: " + statusKoneksi);
        System.out.println("Jenis Koneksi: " + jenisKoneksi);
    }
}
