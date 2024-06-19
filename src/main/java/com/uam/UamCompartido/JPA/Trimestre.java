/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uam.UamCompartido.JPA;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/**
 *
 * @author LGMX
 */

@Entity
public class Trimestre {
    
    @Id
    @Column(name="idtrimestre")
    private int IdTrimestre;
    @Column(name="nombre")
    private String Nombre;

    public int getIdTrimestre() {
        return IdTrimestre;
    }

    public void setIdTrimestre(int IdTrimestre) {
        this.IdTrimestre = IdTrimestre;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    
    
    
}
