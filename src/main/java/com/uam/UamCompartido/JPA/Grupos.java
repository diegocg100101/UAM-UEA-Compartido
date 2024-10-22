package com.uam.UamCompartido.JPA;

import jakarta.persistence.*;

@Entity
public class Grupos {

    @Id
    @Column(name = "clave_grupo")
    private String clave_grupo;

    @ManyToOne
    @JoinColumn (name = "clave_uea")
    private UEA uea;

    @ManyToOne
    @JoinColumn(name = "unidad")
    private Unidad unidad;

    @ManyToOne
    @JoinColumn(name = "horario")
    private Horario horario;

    @ManyToOne
    @JoinColumn(name = "no_economico")
    private Profesores no_economico;

    @Column (name = "cupo_unidad")
    private String cupo_unidad;

    @ManyToOne
    @JoinColumn(name = "salon")
    private Salon salon;


    public Grupos() {

        this.uea = new UEA();
        this.unidad = new Unidad();
        this.horario = new Horario();
        this.no_economico = new Profesores();
        this.salon = new Salon();
    }

    public String getClave_grupo() {
        return clave_grupo;
    }

    public void setClave_grupo(String clave_grupo) {
        this.clave_grupo = clave_grupo;
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

    public Profesores getNo_economico() {
        return no_economico;
    }

    public void setNo_economico(Profesores no_economico) {
        this.no_economico = no_economico;
    }

    public String getCupo_unidad() {
        return cupo_unidad;
    }

    public void setCupo_unidad(String cupo_unidad) {
        this.cupo_unidad = cupo_unidad;
    }

    public Salon getSalon() {
        return salon;
    }

    public void setSalon(Salon salon) {
        this.salon = salon;
    }
}




