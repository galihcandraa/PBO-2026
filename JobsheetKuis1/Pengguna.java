package JobsheetKuis1;

public abstract class Pengguna {
    protected String nama;
    protected String email;

    public Pengguna(String nama, String email) {
        this.nama = nama;
        this.email = email;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void info() {
        System.out.println("Nama    : " + nama);
        System.out.println("Email   : " + email);
    }
}
