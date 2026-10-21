package model.karyawan;

public class PetugasKebersihan extends Karyawan {
    private String areaKerja;

    public PetugasKebersihan(String nama, int skill, double gaji, String areaKerja) {
        super(nama, skill, gaji);
        this.areaKerja = areaKerja;
    }

    @Override
    public void kerja() {
        System.out.println(nama + " (Kebersihan) di area " + areaKerja);
    }

    public void bersihkan() {
        System.out.println("  " + nama + " membersihkan " + areaKerja);
    }
}
