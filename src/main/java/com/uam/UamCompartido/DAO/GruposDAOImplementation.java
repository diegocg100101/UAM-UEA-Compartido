package com.uam.UamCompartido.DAO;

import com.uam.UamCompartido.Model.Grupos;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class GruposDAOImplementation implements GruposDAO{

    @Autowired
    private EntityManager entityManager;


    @Override
    @Transactional
    public Grupos save(Grupos grupo) {
         try {
             entityManager.persist(grupo);
         }catch (Exception e){
             String ex = e.getLocalizedMessage();
             System.out.println(ex);
         }
         return grupo;
    }

    @Override
    public Grupos GrupoGetByClave() {
        return null;
    }

    @Override
    public List<Grupos> GrupoGetAll() {
        List<Grupos> grupos = new ArrayList<>();
        try {
            TypedQuery<Grupos> queryGrupos = entityManager.createQuery("FROM Grupos ", Grupos.class);
            grupos = queryGrupos.getResultList();

        } catch (Exception e) {
            String ex = e.getLocalizedMessage();
        }
        return grupos;
    }

    @Override
    public void GrupoDelete() {

    }

    @Override
    public void GrupoUpdate() {

    }
}
