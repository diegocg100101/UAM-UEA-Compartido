package com.uam.UamCompartido.Model;

import jakarta.persistence.*;

@Entity
public class Grupos {

    @Id
    @Column(name = "clave")
    private String clave;

    @ManyToOne
    @JoinColumn (name = "claveuea")
    private UEA uea;

    @ManyToOne
    @JoinColumn(name = "unidad")
    private Unidad unidad;

    @ManyToOne
    @JoinColumn(name = "horario")
    private Horario horario;

    @ManyToOne
    @JoinColumn(name = "noeconomico")
    private Profesores noeconomico;

    @Column (name = "cupo")
    private String cupo;

    @ManyToOne
    @JoinColumn(name = "salon")
    private Salon salon;


    public Grupos() {

        this.uea = new UEA();
        this.unidad = new Unidad();
        this.horario = new Horario();
        this.noeconomico = new Profesores();
        this.salon = new Salon();
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
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

    public Profesores getNoeconomico() {
        return noeconomico;
    }

    public void setNoeconomico(Profesores noeconomico) {
        this.noeconomico = noeconomico;
    }

    public String getCupo() {
        return cupo;
    }

    public void setCupo(String cupo) {
        this.cupo = cupo;
    }

    public Salon getSalon() {
        return salon;
    }

    public void setSalon(Salon salon) {
        this.salon = salon;
    }
}




