package com.uam.UamCompartido.DAO;

import com.uam.UamCompartido.Model.Alumnos;

import java.util.List;

public interface AlumnosDAO {

    public List<Alumnos> GetAll();

    public Alumnos findByMatricula(String matricula);

    public Alumnos save(Alumnos alumno);
}
