package Jobsheet3.Tugas;

public class TestBioskop {
    public static void main(String[] args) {
        Tiket tiket1 = new Tiket("Avenger: Endgame",-50000);
        System.out.println("Film: " + tiket1.getJudulFilm());
        System.out.println("Harga tiket: " + tiket1.getHargaDasar());
        System.out.println("Status lunas? " + tiket1.isStatusPembayaran());

        System.out.println("\nMemproses pembayaran...");
        tiket1.lakukanPembayaran();
        System.out.println("Status Lunas Terbaru? " + tiket1.isStatusPembayaran());
    }
}
