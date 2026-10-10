package Jobsheet7.Tugas1;

public class OverloadingMain {
    public static void main(String[] args) {
        Segitiga segitiga = new Segitiga();

        System.out.println("=== Segitiga ===");
        System.out.print("Total sudut jika sudutA = 80: ");
        System.out.println(segitiga.totalSudut(80));
        System.out.print("Total sudut jika sudutA = 80 & sudutB = 40: ");
        System.out.println(segitiga.totalSudut(80, 40));
        System.out.print("Kelling segitiga jika sisiA = 40 & sisiB = 20 & sisiC = 10: ");
        System.out.println(segitiga.keliling(40, 20, 10));
        System.out.print("Kelling segitiga jika sisiA = 25 & sisiB = 15: ");
        System.out.println(segitiga.keliling(25, 15 ));
    }
}
