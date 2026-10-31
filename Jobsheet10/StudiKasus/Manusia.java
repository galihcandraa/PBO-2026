package Jobsheet10.StudiKasus;

public class Manusia {
    public void makanBuah(Buah x) {
        if (x instanceof Apel) {
            System.out.println("Apel langsung dimakan");
            ((Apel) x).tampilkanBiji();
        } else if (x instanceof Pisang) {
            System.out.println("Pisang dikupas terlebih dahulu");
            ((Pisang) x).TampilkanKulit();
        }
        
        System.out.println("Rasanya " + x.rasa);
    }
}
