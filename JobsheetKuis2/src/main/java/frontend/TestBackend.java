package frontend;

import backend.*;

public class TestBackend {
    public static void main(String[] args) {
        Lecturer dosen1 = new Lecturer("DSN01", "Budi Santoso");
        Lecturer dosen2 = new Lecturer("DSN02", "Siti Aminah");
        Lecturer dosen3 = new Lecturer("DSN03", "Andi Wijaya");

        dosen1.save();
        dosen2.save();
        dosen3.save();

        dosen2.setName("Siti Aminah, M.Kom.");
        dosen2.save();

        dosen3.delete();

        System.out.println("=== Semua Data Lecturer ===");
        for (Lecturer d : new Lecturer().getAll()) {
            System.out.println("ID: " + d.getId()
                    + ", Kode: " + d.getKode()
                    + ", Nama: " + d.getName());
        }

        System.out.println("\n=== Hasil Pencarian ===");
        for (Lecturer d : new Lecturer().search("Budi")) {
            System.out.println("ID: " + d.getId()
                    + ", Kode: " + d.getKode()
                    + ", Nama: " + d.getName());
        }
    }
}