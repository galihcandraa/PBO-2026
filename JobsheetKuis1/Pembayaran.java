package JobsheetKuis1;

public abstract class Pembayaran {
    protected double jumlah;
    protected String status = "Belum dibayar";
    protected Kursus kursus;

    public Pembayaran(double jumlah, Kursus kursus) {
        this.jumlah = jumlah;
        this.kursus = kursus;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public abstract double hitungTotal();

    public void info() {
        System.out.println("Kursus       : " + kursus.getNama());
        System.out.println("Harga kursus : " + jumlah);
        System.out.println("Status       : " + status);
    }
}
