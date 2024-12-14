package com.uam.UamCompartido.DAO;

import com.uam.UamCompartido.Model.Salon;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SalonDAOImplementation implements SalonDAO {

    @Autowired
    EntityManager entityManager;

    @Override
    public List<Salon> GetAllSalon() {
        List<Salon> salones = new ArrayList<Salon>();

        try {
            TypedQuery<Salon> querySalon = entityManager.createQuery("FROM salon", Salon.class);
            salones = querySalon.getResultList();
        }catch (Exception e){
            String ex = e.getMessage();
        }
        return salones;
    }
}
