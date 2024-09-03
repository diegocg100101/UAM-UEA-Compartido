package com.uam.UamCompartido.DAO;

import com.uam.UamCompartido.JPA.Profesores;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author diego
 */
@Repository
public class UsuariosDAOImplementation implements UsuariosDAO{

    @Autowired
    private EntityManager entityManager;



    @Override
    public Optional<?> findByEmail(String email) {
        List<Profesores> profesores = new ArrayList<>();
        Optional<Profesores> profesor;
        try{
            TypedQuery<Profesores> queryProf = entityManager.createQuery("FROM Profesores WHERE email = :email", Profesores.class);
            queryProf.setParameter("email", email);
            profesores = queryProf.getResultList();
        } catch (Exception e) {
            String ex = e.getLocalizedMessage();
        }
        return profesor = Optional.ofNullable(profesores.get(0));
    }
}
