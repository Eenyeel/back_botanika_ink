package botanika_controller;

import botanika_core_db.ConectionMySQL;
import botanika_models.Orden;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ControllerOrden {

    public int insertarOrden(Orden o) throws Exception {
        String sql = "{CALL sp_alta_orden(?, ?)}";
        int idGenerado = 0;

        try (
                 Connection conn = new ConectionMySQL().open();  CallableStatement cstmt = conn.prepareCall(sql)) {
            cstmt.setInt(1, o.getIdx_orden_usuario());
            cstmt.setFloat(2, o.getTotal());
            cstmt.execute();
        }

        return idGenerado;
    }

    public void modificarOrden(Orden o) throws Exception {
        String sql = "{CALL sp_modificar_orden(?, ?, ?, ?)}";

        try (
                 Connection conn = new ConectionMySQL().open();  CallableStatement cstmt = conn.prepareCall(sql)) {
            cstmt.setInt(1, o.getId());
            cstmt.setInt(2, o.getIdx_orden_usuario());
            cstmt.setFloat(3, o.getTotal());
            cstmt.setTimestamp(4, new Timestamp(o.getFecha().getTime()));
            cstmt.executeUpdate();
        }
    }

    public String eliminarOrden(Orden o) throws Exception {
        String sql = "{CALL sp_eliminar_orden(?)}";

        try (
                 Connection conn = new ConectionMySQL().open();  CallableStatement cstmt = conn.prepareCall(sql)) {
            cstmt.setInt(1, o.getId());
            cstmt.execute();
        }

        return "Orden eliminada correctamente.";
    }

    public List<Orden> getAll() throws Exception {
        String sql = "SELECT * FROM orden";
        ConectionMySQL connMySQL = new ConectionMySQL();
        Connection conn = connMySQL.open();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List<Orden> ordens = new ArrayList<>();
        while (rs.next()) {
            ordens.add(fill(rs));
        }
        rs.close();
        pstmt.close();
        connMySQL.close();
        return ordens;
    }

    private Orden fill(ResultSet rs) throws SQLException {
        Orden o = new Orden();
        o.setId(rs.getInt("id"));
        o.setIdx_orden_usuario(rs.getInt("usuario_id"));
        o.setTotal(rs.getFloat("total"));
        o.setFecha(rs.getTimestamp("fecha"));
        return o;
    }
}
