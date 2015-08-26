package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class ConnectionManager {

    public static Connection getConnection() {

        Connection conn = null;

        String STR_DRIVER = "org.gjt.mm.mysql.Driver";
        String STR_CONEX = "jdbc:mysql://localhost:3306/DBBANCODEIDEIAS";
        String USER = "root";
        String PASSWORD = "";

        try {
            Class.forName(STR_DRIVER);
            conn = DriverManager.getConnection(STR_CONEX, USER, PASSWORD);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro de connexão com o banco de dado!");
        }

        return conn;
    }
}
