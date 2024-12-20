package com.uam.UamCompartido.Model;

import jakarta.persistence.*;

/**
 * @author diego
 */

@Entity(name = "division")
public class Division {
    @Id
    @Column(name = "iddivision")
    private int idDivision;

    @Column(name = "nombre")
    private String nombre;

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
}
