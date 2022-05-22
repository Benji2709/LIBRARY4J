package Bdd;
import java.sql.Connection;
import java.sql.DriverManager;

public class Connexion {
    //method to connect to the Database
    public static Connection connectorDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver oki");
            String url = "jdbc:mysql://localhost:3306/library";
            String user = "root";
            String password = "Zoo01022001**";
            Connection cnx = DriverManager.getConnection(url, user, password);
            System.out.println("Connexion bien établie ");

            return cnx;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}