package com.uam.UamCompartido.DAO;

import com.uam.UamCompartido.JPA.Horario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class HorarioDAOImplementation implements HorarioDAO {

    @Autowired
    private EntityManager entityManager;


    @Override
    public List<Horario> GetAllHorario() {
        List<Horario> horarios = new ArrayList<>();

        try {
            TypedQuery<Horario> queryHorario = entityManager.createQuery("FROM Horario ", Horario.class);
            horarios = queryHorario.getResultList();
        }catch (Exception e){
            String ex = e.getMessage();

        }
        return horarios;
    }
}
