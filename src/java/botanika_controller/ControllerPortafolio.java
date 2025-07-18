package botanika_controller;

import botanika_core_db.ConectionMySQL;
import botanika_models.Portafolio;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ControllerPortafolio {

    public int insertarPortafolio(Portafolio p) throws Exception {
        String sql = "{CALL sp_alta_portafolio(?, ?, ?)}";
        int idGenerado = 0;

        try (
                 Connection conn = new ConectionMySQL().open();  CallableStatement cstmt = conn.prepareCall(sql)) {
            cstmt.setInt(1, p.getIdx_portafolio_artista());
            cstmt.setString(2, p.getUrl_imagen());
            cstmt.setString(3, p.getDescripcion());
            cstmt.execute();
        }

        return idGenerado;
    }

    public void modificarPortafolio(Portafolio p) throws Exception {
        String sql = "{CALL sp_modificar_portafolio(?, ?, ?, ?)}";

        try (
                 Connection conn = new ConectionMySQL().open();  CallableStatement cstmt = conn.prepareCall(sql)) {
            cstmt.setInt(1, p.getId());
            cstmt.setInt(2, p.getIdx_portafolio_artista());
            cstmt.setString(3, p.getUrl_imagen());
            cstmt.setString(4, p.getDescripcion());
            cstmt.executeUpdate();
        }
    }

    public String eliminarPortafolio(Portafolio p) throws Exception {
        String sql = "{CALL sp_eliminar_portafolio(?)}";

        try (
                 Connection conn = new ConectionMySQL().open();  CallableStatement cstmt = conn.prepareCall(sql)) {
            cstmt.setInt(1, p.getId());
            cstmt.execute();
        }

        return "Portafolio eliminado correctamente.";
    }

    public List<Portafolio> getAll() throws Exception {
        String sql = "SELECT * FROM portafolio";
        ConectionMySQL connMySQL = new ConectionMySQL();
        Connection conn = connMySQL.open();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List<Portafolio> portafolios = new ArrayList<>();
        while (rs.next()) {
            portafolios.add(fill(rs));
        }
        rs.close();
        pstmt.close();
        connMySQL.close();
        return portafolios;
    }

    private Portafolio fill(ResultSet rs) throws SQLException {
        Portafolio p = new Portafolio();
        p.setId(rs.getInt("id"));
        p.setIdx_portafolio_artista(rs.getInt("artista_id"));
        p.setUrl_imagen(rs.getString("url_imagen"));
        p.setDescripcion(rs.getString("descripcion"));
        p.setFecha_subida(rs.getTimestamp("fecha_subida"));
        return p;
    }
}
