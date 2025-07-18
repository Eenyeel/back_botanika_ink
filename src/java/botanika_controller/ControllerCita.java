package botanika_controller;

import botanika_core_db.ConectionMySQL;
import botanika_models.Cita;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ControllerCita {

    public int insertarCita(Cita c) throws Exception {
        String sql = "{CALL sp_alta_cita(?, ?, ?, ?, ?)}";
        int idGenerado = 0;

        try (
            Connection conn = new ConectionMySQL().open();
            CallableStatement cstmt = conn.prepareCall(sql)
        ) {
            cstmt.setDate(1, new java.sql.Date(c.getFecha().getTime()));
            cstmt.setTime(2, new java.sql.Time(c.getHora().getTime()));
            cstmt.setInt(3, c.getIdx_cita_cliente());
            cstmt.setInt(4, c.getIdx_cita_artista());
            cstmt.setInt(5, c.getIdx_cita_estado());
            cstmt.execute();
        }

        return idGenerado; 
    }

    public void modificarCita(Cita c) throws Exception {
        String sql = "{CALL sp_modificar_cita(?, ?, ?, ?, ?, ?)}";

        try (
            Connection conn = new ConectionMySQL().open();
            CallableStatement cstmt = conn.prepareCall(sql)
        ) {
            cstmt.setInt(1, c.getId());
            cstmt.setDate(2, new java.sql.Date(c.getFecha().getTime()));
            cstmt.setTime(3, new java.sql.Time(c.getHora().getTime()));
            cstmt.setInt(4, c.getIdx_cita_estado());
            cstmt.setInt(5, c.getIdx_cita_cliente());
            cstmt.setInt(6, c.getIdx_cita_artista());
            cstmt.executeUpdate();
        }
    }

    public String eliminarCita(Cita c) throws Exception {
        String sql = "{CALL sp_eliminar_cita(?)}";

        try (
            Connection conn = new ConectionMySQL().open();
            CallableStatement cstmt = conn.prepareCall(sql)
        ) {
            cstmt.setInt(1, c.getId());
            cstmt.execute();
        }

        return "Cita eliminada correctamente.";
    }

    public List<Cita> getAll() throws Exception {
        String sql = "SELECT * FROM cita";
        ConectionMySQL connMySQL = new ConectionMySQL();
        Connection conn = connMySQL.open();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List<Cita> citas = new ArrayList<>();
        while (rs.next()){
            citas.add(fill(rs));
        }
        rs.close();
        pstmt.close();
        connMySQL.close();
        return citas;
    }

    private Cita fill(ResultSet rs) throws SQLException {
        Cita c = new Cita();
        c.setId(rs.getInt("id"));
        c.setFecha(rs.getDate("fecha"));
        c.setHora(rs.getTime("hora"));
        c.setIdx_cita_estado(rs.getInt("estado_id"));
        c.setIdx_cita_cliente(rs.getInt("cliente_id"));
        c.setIdx_cita_artista(rs.getInt("artista_id"));
        c.setFecha_solicitud(rs.getTimestamp("fecha_solicitud"));
        return c;
    }
}
