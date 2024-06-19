/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uam.UamCompartido.DAO;

import com.uam.UamCompartido.JPA.Unidad;
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
public class UnidadDAOImplementation implements UnidadDAO{
    
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Unidad> GetAll() {
        List<Unidad> unidades = new ArrayList<>();
        
        try {
            TypedQuery<Unidad> queryUnidad = entityManager.createQuery("FROM Unidad", Unidad.class);
            unidades = queryUnidad.getResultList();
            
        } catch (Exception e) {
            String ex=e.getLocalizedMessage();
        }
        
        return unidades;
    }

}
