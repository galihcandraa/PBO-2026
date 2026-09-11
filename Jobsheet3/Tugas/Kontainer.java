package Jobsheet3.Tugas;

public class Kontainer {
    private String nomorResi;
    private String namaPemilik;
    private float kapasitasMaksimal;
    private float beratMuatanSaatIni;

    public Kontainer(String nomorResi, String namaPemilik, float kapasitasMaksimal) {
        this.nomorResi = nomorResi;
        this.namaPemilik = namaPemilik;
        this.kapasitasMaksimal = kapasitasMaksimal;
    }

    public String getNomorResi() {
        return nomorResi;
    }

    public void setNomorResi(String nomorResi) {
        this.nomorResi = nomorResi;
    }

    public String getNamaPemilik() {
        return namaPemilik;
    }

    public void setNamaPemilik(String namaPemilik) {
        this.namaPemilik = namaPemilik;
    }

    public float getKapasitasMaksimal() {
        return kapasitasMaksimal;
    }

    public void setKapasitasMaksimal(float kapasitasMaksimal) {
        this.kapasitasMaksimal = kapasitasMaksimal;
    }

    public float getBberatMuatanSaatIni() {
        return beratMuatanSaatIni;
    }

    public void tambahMuatan(float beratMuatanSaatIni) {
        if (beratMuatanSaatIni > kapasitasMaksimal) {
            System.out.println("Maaf, berat muatan melebihi kapasitas maksimal kontainer");
        } else {
            this.beratMuatanSaatIni += beratMuatanSaatIni;
        }
    }

    public void turunkanMuatan(float beratMuatanSaatIni) {
        if (beratMuatanSaatIni > (0.5 * this.beratMuatanSaatIni)) {
            System.out.println("Maaf, demi keselamatan, pembongkaran muatan satu kali jalan tidak boleh melebihi 50% dari muatan saat ini");
        } else {
            this.beratMuatanSaatIni -= beratMuatanSaatIni;
        }
    }
}
