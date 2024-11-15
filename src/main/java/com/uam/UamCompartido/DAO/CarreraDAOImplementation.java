package com.uam.UamCompartido.DAO;

import com.uam.UamCompartido.Model.Carrera;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarreraDAOImplementation implements CarreraDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Carrera> GetAll(){
        List<Carrera> carreras = new ArrayList<>();

        try {
            TypedQuery<Carrera> queryCarrera = entityManager.createQuery("FROM Carrera ", Carrera.class);
            carreras  = queryCarrera.getResultList();

        } catch (Exception e) {
            String ex = e.getLocalizedMessage();
        }

        return carreras;
    }
}
