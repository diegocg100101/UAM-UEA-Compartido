package com.uam.UamCompartido.DAO;

import com.uam.UamCompartido.JPA.Profesores;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
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
        Optional<Profesores> profesor = Optional.of(new Profesores());
        try{
            profesor = Optional.ofNullable(entityManager.find(Profesores.class, email));
        } catch (Exception e) {
            String ex = e.getLocalizedMessage();
        }
        return profesor;
    }

    @Override
    @Transactional
    public Profesores save(Profesores profesor) {
        try{
            entityManager.persist(profesor);
        } catch (Exception e) {
            String ex = e.getLocalizedMessage();
        }
        return profesor;
    }
}
