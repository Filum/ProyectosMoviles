package cr.ac.una.registromovimientos.entity;

import java.io.Serializable;
import java.util.Date;
public class Movimiento implements Serializable {

    private int tipo;
    private String descripcion;
    private Date fecha;
    private float monto;


    public Movimiento(int tipo, String descripcion, Date fecha, float monto) {
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.monto = monto;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }
}
