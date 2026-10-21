package model.karyawan;

import model.makanan.Makanan;

public class Koki extends Karyawan {
    private String spesialisasi;

    public Koki(String nama, int skill, double gaji, String spesialisasi) {
        super(nama, skill, gaji);
        this.spesialisasi = spesialisasi;
    }

    @Override
    public void kerja() {
        System.out.println(nama + " (Koki, " + spesialisasi + ") bekerja di dapur");
    }

    public void masak(Makanan m) {
        tersedia = false;
        m.masak();
        istirahat();
    }

    public void masak(Makanan m, int n) {
        for (int i = 0; i < n; i++)
            masak(m);
    }
}
