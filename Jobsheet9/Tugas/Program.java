package Jobsheet9.Tugas;

public class Program {
    public static void main(String[] args) {
        Keledai keledai = new Keledai("Keledai", 4, "Hehehehe", "Abu-Abu");
        Gorilla gorilla = new Gorilla("Gulali", 4, "Haaum Hauum", "Hitam Manis");
        Singa singa = new Singa("CingaCing", 4, "Roaar Roaaar", "Coklat");

        keledai.displayMakan();
        keledai.displayBinatang();
        keledai.displayData();
        System.out.println();

        gorilla.displayMakan();
        gorilla.displayBinatang();
        gorilla.displayData();
        System.out.println();

        singa.displayMakan();
        singa.displayBinatang();
        singa.displayData();
    }
}