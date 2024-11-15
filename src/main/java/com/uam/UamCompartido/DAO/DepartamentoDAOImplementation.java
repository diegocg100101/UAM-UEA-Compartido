package com.uam.UamCompartido.DAO;

import com.uam.UamCompartido.Model.Departamento;
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
public class DepartamentoDAOImplementation implements DepartamentoDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Departamento> getDepartamentos() {
        List<Departamento> departamentos = new ArrayList<>();

        try {
            TypedQuery<Departamento> queryDepartamento = entityManager.createQuery("FROM Departamento ", Departamento.class);
            departamentos = queryDepartamento.getResultList();
        } catch (Exception e) {
            String ex = e.getLocalizedMessage();
        }

        return departamentos;
    }
}
