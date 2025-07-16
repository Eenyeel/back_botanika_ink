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
public class Cita {
    
    private int id;
    private Date fecha;
    private Date hora;
    private int /*estado_id*/idx_cita_estado; 
    private int /*cliente_id*/idx_cita_cliente;
    private int /*artista_id*/idx_cita_artista;
    private Date fecha_solicitud;

    public Cita() {
    }

    public Cita(Date fecha, Date hora, int idx_cita_estado, int idx_cita_cliente, int idx_cita_artista, Date fecha_solicitud) {
        this.fecha = fecha;
        this.hora = hora;
        this.idx_cita_estado = idx_cita_estado;
        this.idx_cita_cliente = idx_cita_cliente;
        this.idx_cita_artista = idx_cita_artista;
        this.fecha_solicitud = fecha_solicitud;
    }

    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public int getIdx_cita_estado() {
        return idx_cita_estado;
    }

    public void setIdx_cita_estado(int idx_cita_estado) {
        this.idx_cita_estado = idx_cita_estado;
    }

    public int getIdx_cita_cliente() {
        return idx_cita_cliente;
    }

    public void setIdx_cita_cliente(int idx_cita_cliente) {
        this.idx_cita_cliente = idx_cita_cliente;
    }

    public int getIdx_cita_artista() {
        return idx_cita_artista;
    }

    public void setIdx_cita_artista(int idx_cita_artista) {
        this.idx_cita_artista = idx_cita_artista;
    }

    public Date getFecha_solicitud() {
        return fecha_solicitud;
    }

    public void setFecha_solicitud(Date fecha_solicitud) {
        this.fecha_solicitud = fecha_solicitud;
    }

    
    
    
}
