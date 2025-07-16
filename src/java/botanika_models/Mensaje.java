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
public class Mensaje {

    private int id;
    private int /*cita_id*/ idx_mensaje_cita;
    private int /*remitente_id*/ idx_mensaje_remitente;
    private String contenido;
    private Date fecha_envio;

    public Mensaje() {
    }

    public Mensaje(int idx_mensaje_cita, int idx_mensaje_remitente, String contenido, Date fecha_envio) {
        this.idx_mensaje_cita = idx_mensaje_cita;
        this.idx_mensaje_remitente = idx_mensaje_remitente;
        this.contenido = contenido;
        this.fecha_envio = fecha_envio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdx_mensaje_cita() {
        return idx_mensaje_cita;
    }

    public void setIdx_mensaje_cita(int idx_mensaje_cita) {
        this.idx_mensaje_cita = idx_mensaje_cita;
    }

    public int getIdx_mensaje_remitente() {
        return idx_mensaje_remitente;
    }

    public void setIdx_mensaje_remitente(int idx_mensaje_remitente) {
        this.idx_mensaje_remitente = idx_mensaje_remitente;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Date getFecha_envio() {
        return fecha_envio;
    }

    public void setFecha_envio(Date fecha_envio) {
        this.fecha_envio = fecha_envio;
    }

}
