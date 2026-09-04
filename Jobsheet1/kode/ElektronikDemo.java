package Jobsheet1.kode;

public class ElektronikDemo {
    public static void main(String[] args) {
        InputDevice inputDevice = new InputDevice("Acer", true, "Wireless");
        inputDevice.putuskan();
        inputDevice.hubungkan();
        inputDevice.tampilInfo();
        System.out.println()
        ;
        Mouse mouse = new Mouse("Rexus", false, "Wireless", 10, 20);
        mouse.klikKiri();
        mouse.ubahDpi(5);
        mouse.hubungkan();
        mouse.tampilInfo();
        System.out.println();

        Keyboard keyboard = new Keyboard("Rexus", false, null, 80, "Membran");
        keyboard.ketik("Halo ini keyboard");
        keyboard.gantiSwitch("Mechanical");
        keyboard.tampilInfo();
        System.out.println();

        Tws tws = new Tws(100, 15);
        tws.cekPersentase();
        tws.putarMusik();
        tws.tampilInfo();
        System.out.println();

        Magicom magicom = new Magicom(15, "Nonaktif");
        magicom.masak();
        magicom.tampilInfo();
    }
}
