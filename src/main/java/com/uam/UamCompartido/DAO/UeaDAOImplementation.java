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
import com.uam.UamCompartido.Model.UEA;
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
    public void Edit(UEA uea) {
        try {
            TypedQuery<UEA> queryUEA = entityManager.createQuery("FROM UEA WHERE Clave = :clave", UEA.class);
            queryUEA.setParameter("clave", uea.getClave());
            UEA ueaDB = queryUEA.getSingleResult();
            ueaDB.setNombre(uea.getNombre());
            ueaDB.setCreditos(uea.getCreditos());
            ueaDB.setTrimestre(uea.getTrimestre());
            ueaDB.setUnidad(uea.getUnidad());
            ueaDB.setTronco(uea.getTronco());

            entityManager.merge(ueaDB);
        } catch (Exception e) {
            String ex = e.getLocalizedMessage();
        }
    }

    @Override
    public UEA GetByClave(String clave) {
        UEA uea = new UEA();
        try {
            uea = entityManager.find(UEA.class, clave);
        } catch (Exception e) {
            String ex = e.getLocalizedMessage();
        }
        return uea;
    }

    @Override
    public List<UEA> GetAllByClave(String clave) {
        List<UEA> ueas = new ArrayList<>();
        try {
            TypedQuery<UEA> queryUEA = entityManager.createQuery("FROM UEA WHERE Clave LIKE :clave", UEA.class);
            queryUEA.setParameter("clave", "%" + clave + "%");
            ueas = queryUEA.getResultList();
        } catch (Exception e) {
            String ex = e.getLocalizedMessage();
        }
        return ueas;
    }

    @Override
    public List<UEA> GetByNombre(String nombre) {
        List<UEA> ueas = new ArrayList<>();
        try {
            TypedQuery<UEA> queryUEA = entityManager.createQuery("FROM UEA WHERE Nombre LIKE :nombre", UEA.class);
            queryUEA.setParameter("nombre", "%" + nombre + "%");
            ueas = queryUEA.getResultList();
        } catch (Exception e) {
            String ex = e.getLocalizedMessage();
        }
        return ueas;
    }
}
