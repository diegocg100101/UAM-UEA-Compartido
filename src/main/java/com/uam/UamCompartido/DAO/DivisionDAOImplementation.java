package com.uam.UamCompartido.DAO;

import com.uam.UamCompartido.JPA.Division;
import com.uam.UamCompartido.JPA.Unidad;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author diego
 */
@Repository
public class DivisionDAOImplementation implements DivisionDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Division> GetAll() {
        List<Division> divisiones = new ArrayList<>();

        try {
            TypedQuery<Division> queryDivision = entityManager.createQuery("FROM Division", Division.class);
            divisiones = queryDivision.getResultList();
        } catch (Exception e) {
            String ex = e.getLocalizedMessage();
        }

        return divisiones;
    }
}
