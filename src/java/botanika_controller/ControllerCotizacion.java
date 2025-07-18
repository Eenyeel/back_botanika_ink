package botanika_controller;

import botanika_core_db.ConectionMySQL;
import botanika_models.Cotizacion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ControllerCotizacion {

    public int insertarCotizacion(Cotizacion c) throws Exception {
        String sql = "{CALL sp_alta_cotizacion(?, ?, ?)}";
        int idGenerado = 0;

        try (
                 Connection conn = new ConectionMySQL().open();  CallableStatement cstmt = conn.prepareCall(sql)) {
            cstmt.setInt(1, c.getIdx_cotizacion_cita());
            cstmt.setFloat(2, c.getMonto());
            cstmt.setString(3, c.getMensaje());
            cstmt.execute();
        }

        return idGenerado;
    }

    public void modificarCotizacion(Cotizacion c) throws Exception {
        String sql = "{CALL sp_modificar_cotizacion(?, ?, ?, ?)}";

        try (
                 Connection conn = new ConectionMySQL().open();  CallableStatement cstmt = conn.prepareCall(sql)) {
            cstmt.setInt(1, c.getId());
            cstmt.setInt(2, c.getIdx_cotizacion_cita());
            cstmt.setFloat(3, c.getMonto());
            cstmt.setString(4, c.getMensaje());
            cstmt.executeUpdate();
        }
    }

    public String eliminarCotizacion(Cotizacion c) throws Exception {
        String sql = "{CALL sp_eliminar_cotizacion(?)}";

        try (
                 Connection conn = new ConectionMySQL().open();  CallableStatement cstmt = conn.prepareCall(sql)) {
            cstmt.setInt(1, c.getId());
            cstmt.execute();
        }

        return "Cotización eliminada correctamente.";
    }

    public List<Cotizacion> getAll() throws Exception {
        String sql = "SELECT * FROM cotizacion";
        ConectionMySQL connMySQL = new ConectionMySQL();
        Connection conn = connMySQL.open();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List<Cotizacion> cotizacions = new ArrayList<>();
        while (rs.next()) {
            cotizacions.add(fill(rs));
        }
        rs.close();
        pstmt.close();
        connMySQL.close();
        return cotizacions;
    }

    private Cotizacion fill(ResultSet rs) throws SQLException {
        Cotizacion c = new Cotizacion();
        c.setId(rs.getInt("id"));
        c.setIdx_cotizacion_cita(rs.getInt("cita_id"));
        c.setMonto(rs.getFloat("monto"));
        c.setMensaje(rs.getString("mensaje"));
        c.setFecha_creacion(rs.getTimestamp("fecha_creacion"));
        return c;
    }
}
