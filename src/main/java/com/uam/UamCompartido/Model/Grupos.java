package com.uam.UamCompartido.Model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.uam.UamCompartido.DTO.HorarioDTO;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author diego
 */

@Entity(name = "grupos")
public class Grupos {

    @Id
    @Column(name = "clavegrupo")
    private String claveGrupo;

    @OneToOne
    @JoinColumn(name = "claveuea")
    private UEA uea;

    @OneToOne
    @JoinColumn(name = "unidad")
    private Unidad unidad;

    @Column(columnDefinition = "JSON")
    private String horario;

    @Transient
    private List<String> horarioList;

    @OneToOne
    @JoinColumn(name = "noeconomico")
    private Usuarios profesor;

    @Column(name = "cupounidad")
    private int cupoUnidad;

    @OneToOne
    @JoinColumn(name = "salon")
    private Salon salon;

    @Column(name = "inscritos")
    private int inscritos;

    public Grupos() {
        this.unidad = new Unidad();
        this.profesor = new Usuarios();
        this.salon = new Salon();
        this.uea = new UEA();
    }

    public void convertirHorarioAJson() {
        try {
            List<HorarioDTO> horarioDTOList = new ArrayList<>();

            for (String horario : horarioList) {
                String[] dividido = horario.split(",");
                if (dividido.length == 1) {
                    horarioDTOList.add(new HorarioDTO(horarioList.get(0), horarioList.get(1)));
                    break;
                } else {
                    horarioDTOList.add(new HorarioDTO(dividido[0], dividido[1]));
                }
            }

            ObjectMapper objectMapper = new ObjectMapper();
            this.horario = objectMapper.writeValueAsString(horarioDTOList);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            this.horario = "[]";
        }
    }

    public List<String> getHorarioList() {
        return horarioList;
    }

    public void setHorarioList(List<String> horarioList) {
        this.horarioList = horarioList;
    }

    public int getInscritos() {
        return inscritos;
    }

    public void setInscritos(int inscritos) {
        this.inscritos = inscritos;
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

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Usuarios getProfesor() {
        return profesor;
    }

    public void setProfesor(Usuarios profesor) {
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
