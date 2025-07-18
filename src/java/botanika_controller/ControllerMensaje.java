package botanika_controller;

import botanika_core_db.ConectionMySQL;
import botanika_models.Mensaje;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ControllerMensaje {

    public int insertarMensaje(Mensaje m) throws Exception {
        String sql = "{CALL sp_alta_mensaje(?, ?, ?)}";
        int idGenerado = 0;

        try (
                 Connection conn = new ConectionMySQL().open();  CallableStatement cstmt = conn.prepareCall(sql)) {
            cstmt.setInt(1, m.getIdx_mensaje_cita());
            cstmt.setInt(2, m.getIdx_mensaje_remitente());
            cstmt.setString(3, m.getContenido());
            cstmt.execute();
        }

        return idGenerado;
    }

    public void modificarMensaje(Mensaje m) throws Exception {
        String sql = "{CALL sp_modificar_mensaje(?, ?, ?, ?)}";

        try (
                 Connection conn = new ConectionMySQL().open();  CallableStatement cstmt = conn.prepareCall(sql)) {
            cstmt.setInt(1, m.getId());
            cstmt.setInt(2, m.getIdx_mensaje_cita());
            cstmt.setInt(3, m.getIdx_mensaje_remitente());
            cstmt.setString(4, m.getContenido());
            cstmt.executeUpdate();
        }
    }

    public String eliminarMensaje(Mensaje m) throws Exception {
        String sql = "{CALL sp_eliminar_mensaje(?)}";

        try (
                 Connection conn = new ConectionMySQL().open();  CallableStatement cstmt = conn.prepareCall(sql)) {
            cstmt.setInt(1, m.getId());
            cstmt.execute();
        }

        return "Mensaje eliminado correctamente.";
    }

    public List<Mensaje> getAll() throws Exception {
        String sql = "SELECT * FROM mensaje";
        ConectionMySQL connMySQL = new ConectionMySQL();
        Connection conn = connMySQL.open();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List<Mensaje> mensajes = new ArrayList<>();
        while (rs.next()) {
            mensajes.add(fill(rs));
        }
        rs.close();
        pstmt.close();
        connMySQL.close();
        return mensajes;
    }

    private Mensaje fill(ResultSet rs) throws SQLException {
        Mensaje m = new Mensaje();
        m.setId(rs.getInt("id"));
        m.setIdx_mensaje_cita(rs.getInt("cita_id"));
        m.setIdx_mensaje_remitente(rs.getInt("remitente_id"));
        m.setContenido(rs.getString("contenido"));
        m.setFecha_envio(rs.getTimestamp("fecha_envio"));
        return m;
    }
}
