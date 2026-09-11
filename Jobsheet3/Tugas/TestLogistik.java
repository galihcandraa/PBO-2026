package Jobsheet3.Tugas;
import java.util.Scanner;

public class TestLogistik {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Kontainer kontainerAlfa = new Kontainer("REQ-9988", "PT. Maju Bersama", 5000);

        System.out.println("Nama Pemilik Kontainer: " + kontainerAlfa.getNamaPemilik());
        System.out.println("Kapasitas Maksimal    : " + kontainerAlfa.getKapasitasMaksimal() + " kg");
        
        System.out.print("\nMemasukkan muatan baru seberat (kg): ");
        float muatan = sc.nextFloat();
        kontainerAlfa.tambahMuatan(muatan);
        System.out.println("Berat muatan saat ini : " + kontainerAlfa.getBberatMuatanSaatIni() + " kg");
        
        System.out.print("\nMemasukkan muatan baru seberat (kg): ");
        muatan = sc.nextFloat();
        kontainerAlfa.tambahMuatan(muatan);
        System.out.println("Berat muatan saat ini : " + kontainerAlfa.getBberatMuatanSaatIni() + " kg");
        
        System.out.print("\nMembongkar muat/menurunkan barang seberat (kg): ");
        muatan = sc.nextFloat();
        kontainerAlfa.turunkanMuatan(muatan);
        System.out.println("Berat muatan saat ini : " + kontainerAlfa.getBberatMuatanSaatIni() + " kg");
        
        System.out.print("\nMembongkar muat/menurunkan barang seberat (kg): ");
        muatan = sc.nextFloat();
        kontainerAlfa.turunkanMuatan(muatan);
        System.out.println("Berat muatan saat ini : " + kontainerAlfa.getBberatMuatanSaatIni() + " kg");
        sc.close();
    }
}
