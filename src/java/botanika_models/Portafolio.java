/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package botanika_models;

import java.util.Date;

/**
 *
 * @author Angel Santamaria
 */
public class Portafolio {
    
    private int id;
    private int /*artista_id*/ idx_portafolio_artista;
    private String url_imagen;
    private String descripcion;
    private Date fecha_subida;

    public Portafolio() {
    }

    public Portafolio(int idx_portafolio_artista, String url_imagen, String descripcion, Date fecha_subida) {
        this.idx_portafolio_artista = idx_portafolio_artista;
        this.url_imagen = url_imagen;
        this.descripcion = descripcion;
        this.fecha_subida = fecha_subida;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdx_portafolio_artista() {
        return idx_portafolio_artista;
    }

    public void setIdx_portafolio_artista(int idx_portafolio_artista) {
        this.idx_portafolio_artista = idx_portafolio_artista;
    }

    public String getUrl_imagen() {
        return url_imagen;
    }

    public void setUrl_imagen(String url_imagen) {
        this.url_imagen = url_imagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha_subida() {
        return fecha_subida;
    }

    public void setFecha_subida(Date fecha_subida) {
        this.fecha_subida = fecha_subida;
    }
    
}
