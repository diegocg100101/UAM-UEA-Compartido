/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uam.UamCompartido.DAO;

import com.uam.UamCompartido.Model.Trimestre;
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
public class TrimestreDAOImplementation implements TrimestreDAO {

    @Autowired
    private EntityManager entityManager;
    
    @Override
    public List<Trimestre> GetAll() {
        List<Trimestre> trimestres = new ArrayList<>();
        try {
            TypedQuery<Trimestre> queryTrimestres = entityManager.createQuery("FROM trimestre", Trimestre.class);
            trimestres=queryTrimestres.getResultList();
        } catch (Exception e) {
            String ex=e.getLocalizedMessage();
        }
        return trimestres;
    }
    
}
