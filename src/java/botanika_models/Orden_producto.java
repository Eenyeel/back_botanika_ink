/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package botanika_models;

/**
 *
 * @author Angel Santamaria
 */
public class Orden_producto {
    
    private int /*orden_id*/ idx_op_orden;
    private int /*producto_id*/ idx_op_producto;
    private int cantidad;
    private float precio_unitario;

    public Orden_producto() {
    }

    public Orden_producto(int idx_op_orden, int idx_op_producto, int cantidad, float precio_unitario) {
        this.idx_op_orden = idx_op_orden;
        this.idx_op_producto = idx_op_producto;
        this.cantidad = cantidad;
        this.precio_unitario = precio_unitario;
    }

    public int getIdx_op_orden() {
        return idx_op_orden;
    }

    public void setIdx_op_orden(int idx_op_orden) {
        this.idx_op_orden = idx_op_orden;
    }

    public int getIdx_op_producto() {
        return idx_op_producto;
    }

    public void setIdx_op_producto(int idx_op_producto) {
        this.idx_op_producto = idx_op_producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(float precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

}
