package com.uam.UamCompartido.JPA;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * @author diego
 */
@Entity
public class Profesores extends Usuario {

    @Id
    @Column(name = "noeconomico")
    private String NoEconomico;

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
    @JoinColumn(name = "iddepartamento")
    private Departamento departamento;

    @ManyToOne
    @JoinColumn(name = "iddivision")
    private Division division;

    
    public Profesores(){
        this.Unidad = new Unidad();
        this.division = new Division();
        this.departamento = new Departamento();
    }

    public String getNoEconomico() {
        return NoEconomico;
    }

    public void setNoEconomico(String noEconomico) {
        NoEconomico = noEconomico;
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

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
}
