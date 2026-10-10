
import java.sql.*;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Properties;

public class Main {

    static Connection conn;

    public static void main(String[] args) {

        Properties config = new Properties();

        try (FileInputStream input = new FileInputStream("db.properties")) {
            config.load(input);
        } catch (Exception e) {
            System.out.println("Error al leer db.properties");
            e.printStackTrace();
            return;
        }

        String url = config.getProperty("db.url");
        String user = config.getProperty("db.user");
        String password = config.getProperty("db.password");
        System.out.println("URL JDBC: " + url);

        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("CONTROLADOR POSTGRESQL CARGADO");
            System.out.println("URL que se va a conectar: " + url);
            System.out.println("URL entre corchetes: [" + url + "]");
            System.out.println("Controlador registrado: " + DriverManager.getDrivers().hasMoreElements());
            System.out.println("Longitud URL: " + url.length() + " | Longitud sin espacios: " + url.trim().length());
            conn = DriverManager.getConnection(url, user, password);

            System.out.println("CONEXIÓN OK");
            System.out.println(conn.getMetaData().getURL());

            menu();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void menu() {
        Scanner sc = new Scanner(System.in);
        int op = 0;

        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Select");
            System.out.println("2. Insertar");
            System.out.println("3. Actualizar");
            System.out.println("4. Eliminar");
            System.out.println("5. Salir");

            try {
                op = Integer.parseInt(sc.nextLine().trim());

                switch (op) {
                    case 1 -> select();
                    case 2 -> insert(sc);
                    case 3 -> update(sc);
                    case 4 -> delete(sc);
                    case 5 -> System.out.println("Saliendo del programa...");
                }

            } catch (Exception e) {
                System.out.println("Introduce un número válido");
            }

        } while (op != 5);
    }

    static void select() {
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM cliente");

            while (rs.next()) {
                System.out.println(rs.getInt("id") + " " + rs.getString("telefono"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void insert(Scanner sc) {
        try {
            System.out.print("ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Telefono: ");
            String nombre = sc.nextLine();

            PreparedStatement ps = conn.prepareStatement(
                    "INSERT INTO cliente VALUES (?, ?)");

            ps.setInt(1, id);
            ps.setString(2, nombre);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void update(Scanner sc) {
        try {
            System.out.print("ID a actualizar: ");
            int id = Integer.parseInt(sc.nextLine().trim());

            System.out.print("Nuevo telefono: ");
            String telefono = sc.nextLine();

            PreparedStatement ps = conn.prepareStatement(
                    "UPDATE cliente SET telefono=? WHERE id=?");

            ps.setString(1, telefono);
            ps.setInt(2, id);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void delete(Scanner sc) {
        try {
            System.out.print("ID a borrar: ");
            int id = Integer.parseInt(sc.nextLine().trim());

            PreparedStatement ps = conn.prepareStatement(
                    "DELETE FROM cliente WHERE id=?");

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
