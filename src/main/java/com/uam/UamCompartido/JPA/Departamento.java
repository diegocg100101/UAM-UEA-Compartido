package com.uam.UamCompartido.JPA;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/**
 * @author diego
 */

@Entity
public class Departamento {
    @Id
    @Column(name = "iddepartamento")
    private int IdDepartamento;

    @Column(name = "nombre")
    private String Nombre;

    public int getIdDepartamento() {
        return IdDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        IdDepartamento = idDepartamento;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }
}
