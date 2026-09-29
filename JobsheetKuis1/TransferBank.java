package JobsheetKuis1;

public class TransferBank extends Pembayaran {
    private String norek;

    public TransferBank(double jumlah, Kursus kursus, String norek) {
        super(jumlah, kursus);
        this.norek = norek;
    }

    @Override
    public double hitungTotal() {
        double biayaAdmin = 2500;
        return jumlah + biayaAdmin;
    }

    @Override
    public void info() {
        super.info();
        System.out.println("Nomor Rekening: " + norek);
        System.out.println("Dikenai biaya admin Rp. 2.500,00");
    }
}
