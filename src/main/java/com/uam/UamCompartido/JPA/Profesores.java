package com.uam.UamCompartido.JPA;

import jakarta.persistence.*;

/**
 * @author diego
 */

@Entity
public class Profesores {

    @Id
    @Column(name = "noeconomico")
    private String NoEeconomico;

    @Column(name = "nombre")
    private String Nombre;

    @Column(name = "apellidopaterno")
    private String ApellidoPaterno;

    @Column(name = "apellidomaterno")
    private String ApellidoMaterno;

    @ManyToOne
    @JoinColumn(name = "idunidad")
    private Unidad Unidad;

    @ManyToOne
    @JoinColumn(name = "iddivision")
    private Division division;

    public String getNoEeconomico() {
        return NoEeconomico;
    }

    public void setNoEeconomico(String noEeconomico) {
        NoEeconomico = noEeconomico;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellidoPaterno() {
        return ApellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        ApellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return ApellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        ApellidoMaterno = apellidoMaterno;
    }

    public com.uam.UamCompartido.JPA.Unidad getUnidad() {
        return Unidad;
    }

    public void setUnidad(com.uam.UamCompartido.JPA.Unidad unidad) {
        Unidad = unidad;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }
}
