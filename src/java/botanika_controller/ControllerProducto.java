package botanika_controller;

import botanika_core_db.ConectionMySQL;
import botanika_models.Producto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ControllerProducto {

    public int insertarProducto(Producto p) throws Exception {
        String sql = "{CALL sp_alta_producto(?, ?, ?, ?)}";
        int idGenerado = 0;

        try (
                 Connection conn = new ConectionMySQL().open();  CallableStatement cstmt = conn.prepareCall(sql)) {
            cstmt.setString(1, p.getNombre());
            cstmt.setString(2, p.getDescripcion());
            cstmt.setFloat(3, p.getPrecio());
            cstmt.setInt(4, p.getStock());
            cstmt.execute();
        }

        return idGenerado;
    }

    public void modificarProducto(Producto p) throws Exception {
        String sql = "{CALL sp_modificar_producto(?, ?, ?, ?, ?)}";

        try (
                 Connection conn = new ConectionMySQL().open();  CallableStatement cstmt = conn.prepareCall(sql)) {
            cstmt.setInt(1, p.getId());
            cstmt.setString(2, p.getNombre());
            cstmt.setString(3, p.getDescripcion());
            cstmt.setFloat(4, p.getPrecio());
            cstmt.setInt(5, p.getStock());
            cstmt.executeUpdate();
        }
    }

    public String eliminarProducto(Producto p) throws Exception {
        String sql = "{CALL sp_eliminar_producto(?)}";

        try (
                 Connection conn = new ConectionMySQL().open();  CallableStatement cstmt = conn.prepareCall(sql)) {
            cstmt.setInt(1, p.getId());
            cstmt.execute();
        }

        return "Producto eliminado correctamente.";
    }

    public List<Producto> getAll() throws Exception {
        String sql = "SELECT * FROM producto";
        ConectionMySQL connMySQL = new ConectionMySQL();
        Connection conn = connMySQL.open();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List<Producto> productos = new ArrayList<>();
        while (rs.next()) {
            productos.add(fill(rs));
        }
        rs.close();
        pstmt.close();
        connMySQL.close();
        return productos;
    }

    private Producto fill(ResultSet rs) throws SQLException {
        Producto p = new Producto();
        p.setId(rs.getInt("id"));
        p.setNombre(rs.getString("nombre"));
        p.setDescripcion(rs.getString("descripcion"));
        p.setPrecio(rs.getFloat("precio"));
        p.setStock(rs.getInt("stock"));
        p.setFecha_creacion(rs.getTimestamp("fecha_creacion"));
        return p;
    }
}
