/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uam.UamCompartido.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/**
 *
 * @author LGMX
 */

@Entity
public class Tronco {
    
    @Column(name="idtronco")
    @Id
    private int IdTronco;

    @Column(name="nombre")
    private String Nombre;

    public int getIdTronco() {
        return IdTronco;
    }

    public void setIdTronco(int IdTronco) {
        this.IdTronco = IdTronco;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    
    
}
