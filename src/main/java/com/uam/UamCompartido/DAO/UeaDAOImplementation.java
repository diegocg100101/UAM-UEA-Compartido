/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uam.UamCompartido.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.uam.UamCompartido.JPA.UEA;
import jakarta.transaction.Transactional;

/**
 *
 * @author LGMX
 */
@Repository
public class UeaDAOImplementation implements UeaDAO{

    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public void Add(UEA uea) {
        try {
            entityManager.persist(uea);
        } catch (Exception e) {
            String ex = e.getLocalizedMessage();
        }
    }

    @Override
    public List<UEA> GetAll() {
        List<UEA> ueas = new ArrayList<>();
        try {
            TypedQuery<UEA> queryUEA = entityManager.createQuery("FROM UEA", UEA.class);
            ueas=queryUEA.getResultList();
            
        } catch (Exception e) {
            String ex = e.getLocalizedMessage();
        }
        return ueas;
    }

    @Override
    @Transactional
    public void Delete(String clave) {
        UEA uea;
        try {
            uea = entityManager.find(UEA.class, clave);
            entityManager.remove(uea);
        } catch ( Exception e ) {
            String ex = e.getLocalizedMessage();
        }
    }

    @Override
    @Transactional
    public void Edit(String clave, UEA uea) {

    }

}
