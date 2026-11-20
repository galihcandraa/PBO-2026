package backend;

import java.sql.*;
import io.github.cdimascio.dotenv.Dotenv;

public class DBHelper {
    private static Dotenv dotenv = Dotenv.configure()
            .directory(System.getProperty("user.dir"))
            .filename(".env.local")
            .load();

    private static Connection koneksi;
    private static String supabaseUrl = dotenv.get("SUPABASE_URL");

    public static void bukaKoneksi() {
        if (koneksi == null) {
            try {
                String url = supabaseUrl;

                Class.forName("org.postgresql.Driver");
                
                koneksi = DriverManager.getConnection(url);
            } catch (ClassNotFoundException e) {
                System.out.println("Driver PostgreSQL tidak ditemukan!");
                e.printStackTrace();
            } catch (SQLException e) {
                System.out.println("Koneksi ke database gagal!");
                e.printStackTrace();
            }
        }
    }

    public static String insertQueryGetId(String query) {
        bukaKoneksi();
        String result = "";
        try {
            Statement stmt = koneksi.createStatement();
            stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                result = rs.getString(1);
            }
            rs.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static boolean executeQuery(String query) {
        bukaKoneksi();
        boolean result = false;

        try {
            Statement stmt = koneksi.createStatement();
            stmt.executeUpdate(query);
            result = true;

            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static ResultSet selectQuery(String query) {
        bukaKoneksi();
        ResultSet rs = null;

        try {
            Statement stmt = koneksi.createStatement();
            rs = stmt.executeQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
}
