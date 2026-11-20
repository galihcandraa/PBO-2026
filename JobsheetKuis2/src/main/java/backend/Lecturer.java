package backend;

import java.util.ArrayList;
import java.sql.*;

public class Lecturer {

    private String id;
    private String kode;
    private String name;

    public Lecturer() {
    }

    public Lecturer(String kode, String name) {
        this.kode = kode;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Lecturer getById(String id) {
        Lecturer dosen = new Lecturer();
        if (id == null || id.isEmpty() || "0".equals(id)) {
            return dosen;
        }

        ResultSet rs = DBHelper.selectQuery("SELECT * FROM lecturers "
                + " WHERE id = '" + id + "'");

        try {
            while (rs != null && rs.next()) {
                dosen = new Lecturer();
                dosen.setId(rs.getString("id"));
                dosen.setKode(rs.getString("kode"));
                dosen.setName(rs.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dosen;
    }

    public ArrayList<Lecturer> getAll() {
        ArrayList<Lecturer> listLecturer = new ArrayList();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM lecturers");

        try {
            while (rs.next()) {
                Lecturer dosen = new Lecturer();
                dosen.setId(rs.getString("id"));
                dosen.setKode(rs.getString("kode"));
                dosen.setName(rs.getString("name"));

                listLecturer.add(dosen);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listLecturer;
    }

    public ArrayList<Lecturer> search(String keyword) {
        ArrayList<Lecturer> listLecturer = new ArrayList();

        String sql = "SELECT * FROM lecturers WHERE "
                + "   kode LIKE '%" + keyword + "%' "
                + "   OR name LIKE '%" + keyword + "%'";
        ResultSet rs = DBHelper.selectQuery(sql);

        try {
            while (rs.next()) {
                Lecturer dosen = new Lecturer();
                dosen.setId(rs.getString("id"));
                dosen.setKode(rs.getString("kode"));
                dosen.setName(rs.getString("name"));

                listLecturer.add(dosen);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listLecturer;
    }

    public void save() {
        if (this.id == null || this.id.isEmpty() || getById(id).getId() == null) {
            String sql = "INSERT INTO lecturers (kode, name) VALUES ("
                    + "     '" + this.kode + "', "
                    + "     '" + this.name + "' "
                    + "     )";
            this.id = DBHelper.insertQueryGetId(sql);
        } else {
            String sql = "UPDATE lecturers SET "
                    + "     kode = '" + this.kode + "', "
                    + "     name = '" + this.name + "' "
                    + "     WHERE id = '" + this.id + "'";
            DBHelper.executeQuery(sql);
        }
    }

    public void delete() {
        String sql = "DELETE FROM lecturers WHERE id = '" + this.id + "'";
        DBHelper.executeQuery(sql);
    }
}
