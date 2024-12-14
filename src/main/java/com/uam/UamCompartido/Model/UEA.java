/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uam.UamCompartido.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/**
 *
 * @author LGMX
 */
@Entity(name = "uea")
public class UEA {

    @Id
    @Column(name = "clave")
    private String Clave;

    @Column(name = "nombre")
    private String Nombre;

    @ManyToOne
    @JoinColumn(name = "idunidad")
    public Unidad Unidad;

    @Column(name = "creditos")
    private int Creditos;

    @ManyToOne
    @JoinColumn(name = "idtronco")
    public Tronco Tronco;

    @ManyToOne
    @JoinColumn(name = "idtrimestre")
    public Trimestre Trimestre;

    public UEA() {
        this.Trimestre = new Trimestre();
        this.Tronco = new Tronco();
        this.Unidad = new Unidad();
    }

    public String getClave() {
        return Clave;
    }

    public void setClave(String Clave) {
        this.Clave = Clave;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public Unidad getUnidad() {
        return Unidad;
    }

    public void setUnidad(Unidad Unidad) {
        this.Unidad = Unidad;
    }

    public int getCreditos() {
        return Creditos;
    }

    public void setCreditos(int Creditos) {
        this.Creditos = Creditos;
    }

    public Tronco getTronco() {
        return Tronco;
    }

    public void setTronco(Tronco Tronco) {
        this.Tronco = Tronco;
    }

    public Trimestre getTrimestre() {
        return Trimestre;
    }

    public void setTrimestre(Trimestre Trimestre) {
        this.Trimestre = Trimestre;
    }

}
