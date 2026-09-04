package Jobsheet1.kode;

public class Magicom {
    private int kapasitas;
    private String modeMasak;

    public Magicom(int kapasitas, String mode) {
        this.kapasitas = kapasitas;
        modeMasak = mode;
    }

    public void masak() {
        modeMasak = "Cook";
    }

    public void hangatkan() {
        modeMasak = "Warming";
    }

    public void tampilInfo() {
        System.out.println("Kapasitas: " + kapasitas + " L");
        System.out.println("Mode Masak: " + modeMasak);
    }
}
