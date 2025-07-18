package botanika_controller;

import botanika_core_db.ConectionMySQL;
import botanika_models.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ControllerUsuario {

    public int insertarUsuario(Usuario u) throws Exception {
        String sql = "{CALL sp_alta_usuario(?, ?, ?, ?)}";
        int idGenerado = 0;

        try (
                 Connection conn = new ConectionMySQL().open();  CallableStatement cstmt = conn.prepareCall(sql)) {
            cstmt.setString(1, u.getNombre());
            cstmt.setString(2, u.getEmail());
            cstmt.setString(3, u.getContrasena());
            cstmt.setInt(4, u.getIdx_usuario_rol());
            cstmt.execute();
        }

        return idGenerado;
    }

    public void modificarUsuario(Usuario u) throws Exception {
        String sql = "{CALL sp_modificar_usuario(?, ?, ?, ?, ?)}";

        try (
                 Connection conn = new ConectionMySQL().open();  CallableStatement cstmt = conn.prepareCall(sql)) {
            cstmt.setInt(1, u.getId());
            cstmt.setString(2, u.getNombre());
            cstmt.setString(3, u.getEmail());
            cstmt.setString(4, u.getContrasena());
            cstmt.setInt(5, u.getIdx_usuario_rol());
            cstmt.executeUpdate();
        }
    }

    public String eliminarUsuario(Usuario u) throws Exception {
        String sql = "{CALL sp_eliminar_usuario(?)}";

        try (
                 Connection conn = new ConectionMySQL().open();  CallableStatement cstmt = conn.prepareCall(sql)) {
            cstmt.setInt(1, u.getId());
            cstmt.execute();
        }

        return "Usuario eliminado correctamente.";
    }

    public List<Usuario> getAll() throws Exception {

        String sql = "SELECT * FROM usuario";
        ConectionMySQL connMySQL = new ConectionMySQL();
        Connection conn = connMySQL.open();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List<Usuario> usuarios = new ArrayList<>();
        while (rs.next()) {
            usuarios.add(fill(rs));
        }
        rs.close();
        pstmt.close();
        connMySQL.close();
        return usuarios;
    }

    private Usuario fill(ResultSet rs) throws SQLException {
        Usuario u = new Usuario();
        u.setId(rs.getInt("id"));
        u.setNombre(rs.getString("nombre"));
        u.setEmail(rs.getString("email"));
        u.setContrasena(rs.getString("contrasena"));
        u.setFecha_creacion(rs.getTimestamp("fecha_creacion"));
        u.setIdx_usuario_rol(rs.getInt("rol_id"));
        return u;
    }
}
