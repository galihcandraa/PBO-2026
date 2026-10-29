package Jobsheet9.Percobaan2;

public class Rektor {
    public void beriSertifikatCumlaude(ICumlaude mahasiswaCumlaude) {
        System.out.println("Saya REKTOR, memberikan sertifikat cumlaude.");
        System.out.println("Selamat! Silakan perkenalkan diri Anda..");
        mahasiswaCumlaude.lulus();
        mahasiswaCumlaude.meraihIPKTinggi();
        System.out.println("----------------------------------------");
    }
}