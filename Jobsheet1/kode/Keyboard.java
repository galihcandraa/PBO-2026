package Jobsheet1.kode;

public class Keyboard extends InputDevice {
    private int layout;
    private String tipeSwitch;

    public Keyboard(String merk, boolean statusKoneksi, String jenisKoneksi, int layout, String tipeSwitch) {
        super(merk, statusKoneksi, jenisKoneksi);
        this.layout = layout;
        this.tipeSwitch = tipeSwitch;
    }
    public void ketik(String value) {
        System.out.println(value);
    }

    public void gantiSwitch(String tipeSwitch) {
        this.tipeSwitch = tipeSwitch;
    }

    @Override
    public void tampilInfo() {
        super.tampilInfo();
        System.out.println("Layout: " + layout + "%");
        System.out.println("Tipe Switch: " + tipeSwitch);
    }
}
