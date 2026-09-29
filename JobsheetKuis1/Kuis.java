package JobsheetKuis1;

public class Kuis extends Konten {
    private int jmlSoal;

    public Kuis(String judul, int durasi, int jmlSoal) {
        super(judul, durasi);
        this.jmlSoal = jmlSoal;
    }

    @Override
    public void info() {
        super.info();
        System.out.printf("| %-20s %-1d%-16s|\n", "Jumlah soal kuis: ", jmlSoal, " soal");
    }
}
