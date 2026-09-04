package Jobsheet1.kode;

public class Tws {
    private int persentaseBaterai;
    private long kapasitasBaterai;

    public Tws(int persentase, long kapasitas) {
        persentaseBaterai = persentase;
        kapasitasBaterai = kapasitas;
    }

    public void putarMusik() {
        System.out.println("Sedang memutar lagu");
    }

    public void cekPersentase() {
        System.out.println("Persentase betarai TWS: " + persentaseBaterai + "%");
    }

    public void tampilInfo() {
        System.out.println("Persentase Baterai: " + persentaseBaterai + "%");
        System.out.println("KapasitasBaterai: " + kapasitasBaterai + "mAh");
    }
}
