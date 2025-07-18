package botanika_controller;

import botanika_core_db.ConectionMySQL;
import botanika_models.Orden_producto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ControllerOrdenProducto {

    public void insertarOrdenProducto(Orden_producto op) throws Exception {
        String sql = "{CALL sp_alta_orden_producto(?, ?, ?, ?)}";

        try (
            Connection conn = new ConectionMySQL().open();
            CallableStatement cstmt = conn.prepareCall(sql)
        ) {
            cstmt.setInt(1, op.getIdx_op_orden());
            cstmt.setInt(2, op.getIdx_op_producto());
            cstmt.setInt(3, op.getCantidad());
            cstmt.setFloat(4, op.getPrecio_unitario());
            cstmt.execute();
        }
    }

    public void modificarOrdenProducto(Orden_producto op) throws Exception {
        String sql = "{CALL sp_modificar_orden_producto(?, ?, ?, ?)}";

        try (
            Connection conn = new ConectionMySQL().open();
            CallableStatement cstmt = conn.prepareCall(sql)
        ) {
            cstmt.setInt(1, op.getIdx_op_orden());
            cstmt.setInt(2, op.getIdx_op_producto());
            cstmt.setInt(3, op.getCantidad());
            cstmt.setFloat(4, op.getPrecio_unitario());
            cstmt.executeUpdate();
        }
    }

    public String eliminarOrdenProducto(Orden_producto op) throws Exception {
        String sql = "{CALL sp_eliminar_orden_producto(?, ?)}";

        try (
            Connection conn = new ConectionMySQL().open();
            CallableStatement cstmt = conn.prepareCall(sql)
        ) {
            cstmt.setInt(1, op.getIdx_op_orden());
            cstmt.setInt(2, op.getIdx_op_producto());
            cstmt.execute();
        }

        return "Detalle de orden eliminado correctamente.";
    }

    public List<Orden_producto> getAll() throws Exception {
        String sql = "SELECT * FROM orden_producto";
        ConectionMySQL connMySQL = new ConectionMySQL();
        Connection conn = connMySQL.open();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List<Orden_producto> orden_productos = new ArrayList<>();
        while (rs.next()) {
            orden_productos.add(fill(rs));
        }
        rs.close();
        pstmt.close();
        connMySQL.close();
        return orden_productos;
    }

    private Orden_producto fill(ResultSet rs) throws SQLException {
        Orden_producto op = new Orden_producto();
        op.setIdx_op_orden(rs.getInt("orden_id"));
        op.setIdx_op_producto(rs.getInt("producto_id"));
        op.setCantidad(rs.getInt("cantidad"));
        op.setPrecio_unitario(rs.getFloat("precio_unitario"));
        return op;
    }
}
