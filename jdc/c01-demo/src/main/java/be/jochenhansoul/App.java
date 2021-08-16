package be.jochenhansoul;

import com.mysql.cj.jdbc.ConnectionImpl;

import java.sql.*;

/*public class App {
    public static void main(String[] args) {
        Connection connection; // connection to db
        Statement statement; // instruction to db
        ResultSet resultSet; // answer from db
    }
}*/

public class App {
    public static void main(String[] args) {
        //Connection conn = ConnectionImpl.getInstance();
        //Connection conn1  = DriverManager.getConnection("host", "user", "passw"); // iets externs dat we binnen gehaald hebben met maven

        try {
            // connection
            Connection conn  = DriverManager.getConnection("jdbc:mysql://moktok.intecbrussel.org:33306/beers", "beer", "SecurePassword");
            System.out.println("connection created");

            // statement
            Statement statement = conn.createStatement();

            // result
            //statement.executeQuery("s"); //SELECT
            //statement.executeUpdate("s"); //INSERT, UPDATE, DELETE
            ResultSet rs = statement.executeQuery("SELECT * FROM Brewers"); // meestal voor elke methode één resultset
            // moet geen ";" op einde zetten
            // intellij gaat default geen code kunnen nakijken of auto-completen

            while (rs.next()) {
                System.out.println(rs.getString("Name")); // kolom Name opvragen
                rs.getInt("column containing int"); // voor integers op te halen
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
