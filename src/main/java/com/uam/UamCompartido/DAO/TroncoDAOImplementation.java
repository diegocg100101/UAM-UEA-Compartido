/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uam.UamCompartido.DAO;

import com.uam.UamCompartido.Model.Tronco;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author LGMX
 */
@Repository
public class TroncoDAOImplementation implements TroncoDAO{

    @Autowired
    private EntityManager entityManager;
    
    @Override
    public List<Tronco> GetAll() {
        List<Tronco> troncos = new ArrayList<>();
        try {
            TypedQuery<Tronco> queryTronco = entityManager.createQuery("FROM tronco", Tronco.class);
            troncos = queryTronco.getResultList();
        } catch (Exception e) {
            String ex = e.getLocalizedMessage();
        }
        return troncos;
    }
}
