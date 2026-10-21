package model.karyawan;

public abstract class Karyawan {
    protected String nama;
    protected int skill;
    protected double gaji;
    protected boolean tersedia = true;

    public Karyawan(String nama, int skill, double gaji) {
        this.nama = nama;
        this.skill = skill;
        this.gaji = gaji;
    }

    public abstract void kerja();

    public String getPeran() {
        return getClass().getSimpleName();
    }

    public void istirahat() {
        tersedia = true;
    }

    public String getNama() {
        return nama;
    }

    public int getSkill() {
        return skill;
    }

    public double getGaji() {
        return gaji;
    }

    public boolean isTersedia() {
        return tersedia;
    }
}
