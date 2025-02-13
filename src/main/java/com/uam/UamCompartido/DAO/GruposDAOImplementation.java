package com.uam.UamCompartido.DAO;

import com.uam.UamCompartido.Model.Grupos;
import com.uam.UamCompartido.Model.UEA;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author diego
 */
@Repository
public class GruposDAOImplementation implements GruposDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public void Save(Grupos grupo) {
        try {
            entityManager.persist(grupo);
        } catch (Exception e) {
            String ex = e.getLocalizedMessage();
        }
    }

    @Override
    public void Update(Grupos grupo) {
        try {
            TypedQuery<Grupos> queryGrupos = entityManager.createQuery("FROM grupos WHERE claveGrupo = :clave", Grupos.class);
            queryGrupos.setParameter("clave", grupo.getClaveGrupo());
            Grupos grupoDB = queryGrupos.getSingleResult();

            grupoDB.setUea(grupo.getUea());
            grupoDB.setUnidad(grupo.getUnidad());
            grupoDB.setHorario(grupo.getHorario());
            grupoDB.setProfesor(grupo.getProfesor());
            grupoDB.setCupoUnidad(grupo.getCupoUnidad());
            grupoDB.setSalon(grupo.getSalon());
            grupoDB.setInscritos(grupo.getInscritos());

            entityManager.merge(grupoDB);
        } catch (Exception e) {
            String ex = e.getLocalizedMessage();
        }
    }

    @Override
    @Transactional
    public void Delete(String clave) {
        Grupos grupo;
        try {
            grupo = entityManager.find(Grupos.class, clave);
            entityManager.remove(grupo);
        } catch ( Exception e ) {
            String ex = e.getLocalizedMessage();
        }
    }

    @Override
    public List<Grupos> GetAll() {
        List<Grupos> grupos = new ArrayList<>();
        try {
            TypedQuery<Grupos> queryGrupos = entityManager.createQuery("FROM grupos", Grupos.class);
            grupos = queryGrupos.getResultList();

        } catch (Exception e) {
            String ex = e.getLocalizedMessage();
        }
        return grupos;
    }

    @Override
    public Grupos GetByClave(String clave) {
        Grupos grupo = new Grupos();
        try {
            grupo = entityManager.find(Grupos.class, clave);
        } catch (Exception e) {
            String ex = e.getLocalizedMessage();
        }
        return grupo;
    }

    @Override
    public List<Grupos> GetByUnidad(String unidad) {
        List<Grupos> grupos = new ArrayList<>();
        try {
            TypedQuery<Grupos> queryGrupos = entityManager.createQuery("FROM grupos g WHERE g.unidad.IdUnidad = :unidad", Grupos.class);
            queryGrupos.setParameter("unidad", Integer.parseInt(unidad));
            grupos = queryGrupos.getResultList();
        } catch (Exception e) {
            String ex = e.getLocalizedMessage();
        }
        return grupos;
    }
}
