package repositorios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class DAO {

    Connection conn = null;

    static {
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE,
                    ex.getMessage(), ex);
        }
    }

    public Connection getConnection(boolean autoCommit) throws SQLException {
        conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bdaguasareia", "postgres", "root");

        conn.setAutoCommit(autoCommit);
        return conn;
    }
}
