package botanika_controller;

import botanika_core_db.ConectionMySQL;
import botanika_models.Rol;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Angel Santamaria
 */
public class ControllerRol {

    public List<Rol> getAll() throws Exception {

        String sql = "SELECT * FROM rol";
        ConectionMySQL connMySQL = new ConectionMySQL();
        Connection conn = connMySQL.open();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List<Rol> rols = new ArrayList<>();
        while (rs.next()) {
            rols.add(fill(rs));
        }
        rs.close();
        pstmt.close();
        connMySQL.close();
        return rols;
    }

    private Rol fill(ResultSet rs) throws SQLException {
        Rol r = new Rol();
        r.setId(rs.getInt("id"));
        r.setNombre(rs.getString("nombre"));
        return r;
    }
}
