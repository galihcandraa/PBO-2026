package Jobsheet7.Tugas2;

public class OverridingMain {
    public static void main(String[] args) {
        Manusia manusia;

        manusia = new Manusia();
        manusia.bernafas();
        manusia.makan();
        System.out.println();

        manusia = new Dosen();
        manusia.bernafas(); 
        manusia.makan();             
        ((Dosen) manusia).lembur(); 
        System.out.println();

        manusia = new Mahasiswa();
        manusia.bernafas();
        manusia.makan();                
        ((Mahasiswa) manusia).tidur(); 
    }
}