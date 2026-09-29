package JobsheetKuis1;

public class EWallet extends Pembayaran {
    private String noHp;

    public EWallet(double jumlah, Kursus kursus, String noHp) {
        super(jumlah, kursus);
        this.noHp = noHp;
    }

    @Override
    public double hitungTotal() {
        double pajak = 0.001;
        return jumlah + (jumlah * pajak);
    }

    @Override
    public void info() {
        super.info();
        System.out.println("Nomor HP: " + noHp);
        System.out.println("Dikenai pajak 0,1%");
    }
}
