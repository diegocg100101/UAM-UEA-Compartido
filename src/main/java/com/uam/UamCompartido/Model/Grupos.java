package com.uam.UamCompartido.Model;

import jakarta.persistence.*;

/**
 * @author diego
 */

@Entity(name = "grupos")
public class Grupos {

    @Id
    @Column(name = "clavegrupo")
    private String claveGrupo;

    @ManyToOne
    @JoinColumn(name = "claveuea")
    private UEA uea;

    @ManyToOne
    @JoinColumn(name = "unidad")
    private Unidad unidad;

    @ManyToOne
    @JoinColumn(name = "horario")
    private Horario horario;

    @ManyToOne
    @JoinColumn(name = "noeconomico")
    private Profesores profesor;

    @Column(name = "cupounidad")
    private int cupoUnidad;

    @ManyToOne
    @JoinColumn(name = "salon")
    private Salon salon;

    public Grupos() {
        this.unidad = new Unidad();
        this.horario = new Horario();
        this.profesor = new Profesores();
        this.salon = new Salon();
        this.uea = new UEA();
    }

    public String getClaveGrupo() {
        return claveGrupo;
    }

    public void setClaveGrupo(String claveGrupo) {
        this.claveGrupo = claveGrupo;
    }

    public UEA getUea() {
        return uea;
    }

    public void setUea(UEA uea) {
        this.uea = uea;
    }

    public Unidad getUnidad() {
        return unidad;
    }

    public void setUnidad(Unidad unidad) {
        this.unidad = unidad;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public Profesores getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesores profesor) {
        this.profesor = profesor;
    }

    public int getCupoUnidad() {
        return cupoUnidad;
    }

    public void setCupoUnidad(int cupoUnidad) {
        this.cupoUnidad = cupoUnidad;
    }

    public Salon getSalon() {
        return salon;
    }

    public void setSalon(Salon salon) {
        this.salon = salon;
    }
}
