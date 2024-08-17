package com.uam.UamCompartido.JPA;

import jakarta.persistence.*;

/**
 * @author diego
 */

@Entity
public class Division {
    @Id
    @Column(name = "idDivision")
    private int idDivision;

    @Column(name = "nombre")
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "idUnidad")
    private Unidad unidad;

    public int getIdDivision() {
        return idDivision;
    }

    public void setIdDivision(int idDivision) {
        this.idDivision = idDivision;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Unidad getUnidad() {
        return unidad;
    }

    public void setUnidad(Unidad unidad) {
        this.unidad = unidad;
    }
}
