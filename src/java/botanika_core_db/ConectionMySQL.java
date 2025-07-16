
package botanika_core_db;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Angel Santamaria
 */
public class ConectionMySQL {
    
    Connection conn;

    public Connection open() {
        String user = "root";
        String password = "admin";
        String url = "jdbc:mysql://127.0.0.1:3306/botanika_db?"
                + "uneSSL=false&useUnicode=true&"
                + "characterEncoding="
                + "utf-8";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
            return conn;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void close() {
        if (conn != null) {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Excepcion controlada");
            }
        }
    }
}
