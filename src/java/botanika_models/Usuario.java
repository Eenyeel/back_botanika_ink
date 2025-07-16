
package botanika_models;

import java.util.Date;

public class Usuario {

    private int id;
    private String nombre;
    private String email;
    private String contrasena;
    
    private Date fecha_creacion;
    private int /*rol_id*/idx_usuario_rol;

    public Usuario() {
    }

    public Usuario(String nombre, String email, String contrasena, Date fecha_creacion, int idx_usuario_rol) {
        this.nombre = nombre;
        this.email = email;
        this.contrasena = contrasena;
        this.fecha_creacion = fecha_creacion;
        this.idx_usuario_rol = idx_usuario_rol;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public int getIdx_usuario_rol() {
        return idx_usuario_rol;
    }

    public void setIdx_usuario_rol(int idx_usuario_rol) {
        this.idx_usuario_rol = idx_usuario_rol;
    }
    
    
    
        
}
