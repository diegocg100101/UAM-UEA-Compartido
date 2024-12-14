package com.uam.UamCompartido.DAO;

import com.uam.UamCompartido.Model.Grupos;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author diego
 */
@Repository
public class GruposDAOImplementation implements GruposDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public void Save(Grupos grupo) {
        try {
            entityManager.persist(grupo);
        } catch (Exception e) {
            String ex = e.getLocalizedMessage();
        }
    }

    @Override
    public void Update(Grupos grupo) {
    }

    @Override
    public void Delete(Grupos grupo) {

    }

    @Override
    public List<Grupos> GetAll() {
        return List.of();
    }
}
