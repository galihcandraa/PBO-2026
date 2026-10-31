package Jobsheet10.Praktikum3;

public class Bayaran {
    public int hitungBayaran(Pegawai pg) {
        int uang = pg.getGaji();

        if (pg instanceof Manajer m) {
            uang += m.getTunjangan();
        } else if (pg instanceof Programmer p) {
            uang += p.getBonus();
        }

        return uang;
    }
}
