package com.uam.UamCompartido.JPA;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Alumnos {
    @Id
    @Column(name = "matricula")
    private String Matricula;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellidopaterno" )
    private String ApellidoPaterno;

    @Column (name = "apellidomaterno")
    private String ApellidoMaterno;

    @ManyToOne
    @Column(name = "idunidad")
    private Unidad unidad;

    @ManyToOne
    @Column(name = "iddivision")
    private Division division;

    @ManyToOne
    @Column(name = "idcarrera")
    private Carrera carrera;

    public Alumnos() {
        this.unidad = new Unidad();
        this.division = new Division();
        this.carrera = new Carrera();
    }

    public String getMatricula() {
        return Matricula;
    }

    public void setMatricula(String matricula) {
        Matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public Unidad getUnidad() {
        return unidad;
    }

    public void setUnidad(Unidad unidad) {
        this.unidad = unidad;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }
}
