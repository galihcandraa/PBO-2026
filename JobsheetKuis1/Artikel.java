package JobsheetKuis1;

public class Artikel extends Konten {
    private int jmlKata;

    public Artikel(String judul, int durasi, int jmlKata) {
        super(judul, durasi);
        this.jmlKata = jmlKata;
    }

    @Override
    public void info() {
        super.info();
        System.out.printf("| %-20s %-1d%-11s|\n", "Jumlah kata di artikel: ", jmlKata, " kata");
    }
}
