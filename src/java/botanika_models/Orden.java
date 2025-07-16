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
public class Orden {
    
private int id;
private int /*usuario_id*/ idx_orden_usuario;
private float total;
private Date fecha;

    public Orden() {
    }

    public Orden(int idx_orden_usuario, float total, Date fecha) {
        this.idx_orden_usuario = idx_orden_usuario;
        this.total = total;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdx_orden_usuario() {
        return idx_orden_usuario;
    }

    public void setIdx_orden_usuario(int idx_orden_usuario) {
        this.idx_orden_usuario = idx_orden_usuario;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

}
