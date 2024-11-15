package com.uam.UamCompartido.DAO;

import com.uam.UamCompartido.Model.Alumnos;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AlumnosDAOImplementation  implements AlumnosDAO{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Alumnos> GetAll() {
        return List.of();
    }

    @Override
    public Alumnos findByMatricula(String matricula) {
        Alumnos alumno = new Alumnos();
        try {
            alumno = entityManager.find(Alumnos.class, matricula);
        }catch (Exception e){
            String ex = e.getMessage();
        }
        return alumno;
    }

    @Override
    @Transactional
    public Alumnos save(Alumnos alumno) {
        try {
            entityManager.persist(alumno);
        }catch (Exception e){
            String ex = e.getMessage();
            System.out.println(ex);
        }
        return alumno;
    }
}
