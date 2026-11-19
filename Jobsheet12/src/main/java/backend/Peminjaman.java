package backend;

import java.util.ArrayList;
import java.sql.*;

public class Peminjaman {

    private int idpeminjaman;
    private Anggota anggota = new Anggota();
    private Buku buku = new Buku();
    private String tanggalPinjam;
    private String tanggalKembali;

    public int getIdpeminjaman() {
        return idpeminjaman;
    }

    public void setIdpeminjaman(int idpeminjaman) {
        this.idpeminjaman = idpeminjaman;
    }

    public Anggota getAnggota() {
        return anggota;
    }

    public void setAnggota(Anggota anggota) {
        this.anggota = anggota;
    }

    public Buku getBuku() {
        return buku;
    }

    public void setBuku(Buku buku) {
        this.buku = buku;
    }

    public String getTanggalPinjam() {
        return tanggalPinjam;
    }

    public void setTanggalPinjam(String tanggalPinjam) {
        this.tanggalPinjam = tanggalPinjam;
    }

    public String getTanggalKembali() {
        return tanggalKembali;
    }

    public void setTanggalKembali(String tanggalKembali) {
        this.tanggalKembali = tanggalKembali;
    }

    public Peminjaman() {
    }

    public Peminjaman(Anggota anggota, Buku buku, String tanggalPinjam, String tanggalKembali) {
        this.anggota = anggota;
        this.buku = buku;
        this.tanggalPinjam = tanggalPinjam;
        this.tanggalKembali = tanggalKembali;
    }

    public Peminjaman getById(int id) {
        Peminjaman peminjaman = new Peminjaman();
        ResultSet rs = DBHelper.selectQuery("SELECT "
                + "p.id_peminjaman AS id_peminjaman, "
                + "p.tanggal_pinjam AS tanggal_pinjam, "
                + "p.tanggal_kembali AS tanggal_kembali, "
                + "a.id_anggota AS id_anggota, "
                + "a.nama AS nama, "
                + "a.alamat AS alamat, "
                + "a.telepon AS telepon, "
                + "b.id_buku AS id_buku, "
                + "b.judul AS judul, "
                + "b.penerbit AS penerbit, "
                + "b.penulis AS penulis "
                + "FROM peminjaman p "
                + "LEFT JOIN anggota a ON p.id_anggota = a.id_anggota "
                + "LEFT JOIN buku b ON p.id_buku = b.id_buku "
                + "WHERE p.id_peminjaman = '" + id + "'");

        try {
            while (rs.next()) {
                peminjaman = new Peminjaman();
                peminjaman.setIdpeminjaman(rs.getInt("id_peminjaman"));
                peminjaman.getAnggota().setIdAnggota(rs.getInt("id_anggota"));
                peminjaman.getAnggota().setNama(rs.getString("nama"));
                peminjaman.getAnggota().setAlamat(rs.getString("alamat"));
                peminjaman.getAnggota().setTelepon(rs.getString("telepon"));
                peminjaman.getBuku().setIdbuku(rs.getInt("id_buku"));
                peminjaman.getBuku().setJudul(rs.getString("judul"));
                peminjaman.getBuku().setPenerbit(rs.getString("penerbit"));
                peminjaman.getBuku().setPenulis(rs.getString("penulis"));
                peminjaman.setTanggalPinjam(rs.getString("tanggal_pinjam"));
                peminjaman.setTanggalKembali(rs.getString("tanggal_kembali"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return peminjaman;
    }

    public ArrayList<Peminjaman> getAll() {
        ArrayList<Peminjaman> ListPeminjaman = new ArrayList();

        ResultSet rs = DBHelper.selectQuery("SELECT "
                + "p.id_peminjaman AS id_peminjaman, "
                + "p.tanggal_pinjam AS tanggal_pinjam, "
                + "p.tanggal_kembali AS tanggal_kembali, "
                + "a.id_anggota AS id_anggota, "
                + "a.nama AS nama, "
                + "a.alamat AS alamat, "
                + "a.telepon AS telepon, "
                + "b.id_buku AS id_buku, "
                + "b.judul AS judul, "
                + "b.penerbit AS penerbit, "
                + "b.penulis AS penulis "
                + "FROM peminjaman p "
                + "LEFT JOIN anggota a ON p.id_anggota = a.id_anggota "
                + "LEFT JOIN buku b ON p.id_buku = b.id_buku");

        try {
            while (rs.next()) {
                Peminjaman peminjaman = new Peminjaman();
                peminjaman.setIdpeminjaman(rs.getInt("id_peminjaman"));
                peminjaman.getAnggota().setIdAnggota(rs.getInt("id_anggota"));
                peminjaman.getAnggota().setNama(rs.getString("nama"));
                peminjaman.getAnggota().setAlamat(rs.getString("alamat"));
                peminjaman.getAnggota().setTelepon(rs.getString("telepon"));
                peminjaman.getBuku().setIdbuku(rs.getInt("id_buku"));
                peminjaman.getBuku().setJudul(rs.getString("judul"));
                peminjaman.getBuku().setPenerbit(rs.getString("penerbit"));
                peminjaman.getBuku().setPenulis(rs.getString("penulis"));
                peminjaman.setTanggalPinjam(rs.getString("tanggal_pinjam"));
                peminjaman.setTanggalKembali(rs.getString("tanggal_kembali"));

                ListPeminjaman.add(peminjaman);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ListPeminjaman;
    }

    public ArrayList<Peminjaman> search(String keyword) {
        ArrayList<Peminjaman> ListPeminjaman = new ArrayList();

        ResultSet rs = DBHelper.selectQuery("SELECT "
                + "p.id_peminjaman AS id_peminjaman, "
                + "p.tanggal_pinjam AS tanggal_pinjam, "
                + "p.tanggal_kembali AS tanggal_kembali, "
                + "a.id_anggota AS id_anggota, "
                + "a.nama AS nama, "
                + "a.alamat AS alamat, "
                + "a.telepon AS telepon, "
                + "b.id_buku AS id_buku, "
                + "b.judul AS judul, "
                + "b.penerbit AS penerbit, "
                + "b.penulis AS penulis "
                + "FROM peminjaman p "
                + "LEFT JOIN anggota a ON p.id_anggota = a.id_anggota "
                + "LEFT JOIN buku b ON p.id_buku = b.id_buku "
                + "WHERE a.nama LIKE '%" + keyword + "%' "
                + "OR b.judul LIKE '%" + keyword + "%'");

        try {
            while (rs.next()) {
                Peminjaman peminjaman = new Peminjaman();
                peminjaman.setIdpeminjaman(rs.getInt("id_peminjaman"));
                peminjaman.getAnggota().setIdAnggota(rs.getInt("id_anggota"));
                peminjaman.getAnggota().setNama(rs.getString("nama"));
                peminjaman.getAnggota().setAlamat(rs.getString("alamat"));
                peminjaman.getAnggota().setTelepon(rs.getString("telepon"));
                peminjaman.getBuku().setIdbuku(rs.getInt("id_buku"));
                peminjaman.getBuku().setJudul(rs.getString("judul"));
                peminjaman.getBuku().setPenerbit(rs.getString("penerbit"));
                peminjaman.getBuku().setPenulis(rs.getString("penulis"));
                peminjaman.setTanggalPinjam(rs.getString("tanggal_pinjam"));
                peminjaman.setTanggalKembali(rs.getString("tanggal_kembali"));

                ListPeminjaman.add(peminjaman);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ListPeminjaman;
    }

    public void save() {
        if (getById(idpeminjaman).getIdpeminjaman() == 0) {
            String SQL = "INSERT INTO peminjaman (id_anggota, id_buku, tanggal_pinjam, tanggal_kembali) VALUES("
                    + "'" + this.getAnggota().getIdAnggota() + "', "
                    + "'" + this.getBuku().getIdbuku() + "', "
                    + "'" + this.tanggalPinjam + "', "
                    + "'" + this.tanggalKembali + "'"
                    + ")";
            this.idpeminjaman = DBHelper.insertQueryGetId(SQL);
        } else {
            String SQL = "UPDATE peminjaman SET "
                    + "id_anggota = '" + this.getAnggota().getIdAnggota() + "', "
                    + "id_buku = '" + this.getBuku().getIdbuku() + "', "
                    + "tanggal_pinjam = '" + this.tanggalPinjam + "', "
                    + "tanggal_kembali = '" + this.tanggalKembali + "' "
                    + "WHERE id_peminjaman = '" + this.idpeminjaman + "'";
            DBHelper.executeQuery(SQL);
        }
    }

    public void delete() {
        String SQL = "DELETE FROM peminjaman WHERE id_peminjaman = '" + this.idpeminjaman + "'";
        DBHelper.executeQuery(SQL);
    }
}
