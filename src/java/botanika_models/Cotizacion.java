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
public class Cotizacion {
    
    private int id;
    private int /*cita_id*/ idx_cotizacion_cita;
    private float monto;
    private String mensaje;
    private Date fecha_creacion;

    public Cotizacion() {
    }

    public Cotizacion(int idx_cotizacion_cita, float monto, String mensaje) {
        this.idx_cotizacion_cita = idx_cotizacion_cita;
        this.monto = monto;
        this.mensaje = mensaje;
    }
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdx_cotizacion_cita() {
        return idx_cotizacion_cita;
    }

    public void setIdx_cotizacion_cita(int idx_cotizacion_cita) {
        this.idx_cotizacion_cita = idx_cotizacion_cita;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }
    
}
