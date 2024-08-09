package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BD {


    public static Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:./DH-Backend1", "sa", "sa");
    }

    public static void createTable() {
        Connection connection = null;

        try {
            connection = getConnection();

            Statement statement = connection.createStatement();

            String script = "src/script.sql";
            executeSqlScript(statement, script);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    private static void executeSqlScript(Statement statement, String scriptPath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(scriptPath))) {
            StringBuilder sql = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                sql.append(line);
                sql.append(System.lineSeparator());
                if (line.trim().endsWith(";")) {
                    statement.execute(sql.toString());
                    sql.setLength(0); // Reset the StringBuilder
                }
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}

