package com.uam.UamCompartido.DAO;

import com.uam.UamCompartido.JPA.Profesores;
import com.uam.UamCompartido.JPA.UEA;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author diego
 */
@Repository
public class ProfesoresDAOImplementation implements ProfesoresDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Profesores> GetAll() {
        return List.of();
    }

    @Override
    public Profesores findByNoEconomico(String noEconomico) {
        Profesores profesor = new Profesores();
        try {
            profesor = entityManager.find(Profesores.class, noEconomico);
        } catch (Exception e) {
            String ex = e.getLocalizedMessage();
        }
        return profesor;
    }

    @Override
    public Optional<Profesores> findByEmail(String email) {
        List<Profesores> profesores = new ArrayList<>();
        Optional<Profesores> profesor;
        try{
            TypedQuery<Profesores> queryProf = entityManager.createQuery("FROM Profesores WHERE email = :email", Profesores.class);
            queryProf.setParameter("email", "%" + email + "%");
            profesores = queryProf.getResultList();
        } catch (Exception e) {
            String ex = e.getLocalizedMessage();
        }
        return profesor = Optional.ofNullable(profesores.get(0));
    }

    @Override
    @Transactional
    public Profesores save(Profesores profesor) {
        try{
            entityManager.persist(profesor);
        } catch (Exception e) {
            String ex = e.getLocalizedMessage();
            System.out.println(ex);
        }
        return profesor;
    }
}
