
package botanika_controller;

import botanika_core_db.ConectionMySQL;
import botanika_models.Estado_cita;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ControllerEstadoCita {


    public List<Estado_cita> getAll() throws Exception {
        String sql = "SELECT * FROM estado_cita";
        List<Estado_cita> estado_citas = new ArrayList<>();

        try (
            Connection conn = new ConectionMySQL().open();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery()
        ) {
            while (rs.next()) {
                estado_citas.add(fill(rs));
            }
        }

        return estado_citas;
    }

    private Estado_cita fill(ResultSet rs) throws SQLException {
        Estado_cita e = new Estado_cita();
        e.setId(rs.getInt("id"));
        e.setNombre(rs.getString("nombre"));
        return e;
    }
    
}
