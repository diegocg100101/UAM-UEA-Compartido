package com.uam.UamCompartido.Model;

import jakarta.persistence.*;

/**
 * @author diego
 */

@Entity
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idrol")
    private int idRol;

    @Column(name = "nombre")
    private String nombre;

    public long getIdRol() {
        return idRol;
    }

    public void setIdRol(int id) {
        this.idRol = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
