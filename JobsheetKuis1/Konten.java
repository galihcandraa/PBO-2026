package JobsheetKuis1;

public abstract class Konten {
    protected String judul;
    protected int durasi;

    public Konten(String judul, int durasi) {
        this.judul = judul;
        this.durasi = durasi;
    }

    public void info() {
        System.out.printf("| %-30s| %-6d | \n", judul, durasi);
    }
}
