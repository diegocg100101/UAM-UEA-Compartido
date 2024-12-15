package com.uam.UamCompartido.DAO;

import com.uam.UamCompartido.Model.Horario;
import com.uam.UamCompartido.Model.Profesores;
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
            TypedQuery<Horario> queryHorario = entityManager.createQuery("FROM horario", Horario.class);
            horarios = queryHorario.getResultList();
        }catch (Exception e){
            String ex = e.getMessage();

        }
        return horarios;
    }

    @Override
    public Horario GetHorarioById(Integer id) {
        Horario horario = new Horario();
        try {
            horario = entityManager.find(Horario.class, id);
        } catch (Exception e) {
            String ex = e.getLocalizedMessage();
        }
        return horario;
    }
}
