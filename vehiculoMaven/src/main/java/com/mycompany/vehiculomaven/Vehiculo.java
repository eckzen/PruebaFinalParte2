
package com.mycompany.vehiculomaven;

import java.util.Date;
import javax.persistence.*;

@Entity
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    private String tipo;
    private String marca;
    private int potencia;
    @Column(name = "FechaCompra")
    private Date fechaCompra;

    public Vehiculo() {
    }

    public Vehiculo(int id, String tipo, String marca, int potencia, Date fechaCompra) {
        this.id = id;
        this.tipo = tipo;
        this.marca = marca;
        this.potencia = potencia;
        this.fechaCompra = fechaCompra;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }
}

