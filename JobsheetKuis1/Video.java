package JobsheetKuis1;

public class Video extends Konten {
    private String resolusi;

    public Video(String judul, int durasi, String resolusi) {
        super(judul, durasi);
        this.resolusi = resolusi;
    }

    @Override
    public void info() {
        super.info();
        System.out.printf("| %-20s %-1s%-13s|\n", "Resolusi video: ", resolusi, "");
    }
}
