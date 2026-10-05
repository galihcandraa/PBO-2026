package Jobsheet6.Tugas;

public class TiketDemo {
    public static void main(String[] args) {
        TiketKereta tiketKereta = new TiketKereta();
        tiketKereta.kodeTiket = "KA-001";
        tiketKereta.namaPenumpang = "Andi";
        tiketKereta.asal = "Malang";
        tiketKereta.tujuan = "Jakarta";
        tiketKereta.hargaDasar = 350000;
        tiketKereta.nomorGerbong = 3;
        tiketKereta.nomorKursi = "12A";
        System.out.println("========== Tiket Kereta ==========");
        tiketKereta.tampilKereta();
        
        TiketDomestik tiketDomestik = new TiketDomestik(
            "GA-102", "Sinta", "Surabaya", "Denpasar", 900000, "Garuda Indonesia", 25, 75000);
            System.out.println("========== Tiket Pesawat Domestik ==========");
            tiketDomestik.tampilDomestik();
            
            TiketInternasional tiketInternasional = new TiketInternasional(
                "SQ-205", "Budi", "Jakarta", "Singapura", 2500000, "Singapore Airlines", 20, "C1234567", 150000);
                System.out.println("========== Tiket Pesawat Internasional ==========");
        tiketInternasional.tampilInternasional();
    }
}
