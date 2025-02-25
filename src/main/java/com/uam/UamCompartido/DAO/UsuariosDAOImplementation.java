package com.uam.UamCompartido.DAO;

import com.uam.UamCompartido.Model.UEA;
import com.uam.UamCompartido.Model.Usuarios;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author diego
 */
@Repository
public class UsuariosDAOImplementation implements UsuariosDAO{

    @Autowired
    private EntityManager entityManager;

    @Override
    public Usuarios getByNumero(String numero) {
        Usuarios usuario = new Usuarios();
        try {
            usuario = entityManager.find(Usuarios.class, numero);
        } catch (Exception e) {
            String ex = e.getLocalizedMessage();
        }
        return usuario;
    }

    @Override
    public Optional<Usuarios> findByEmail(String email) {
        List<Usuarios> usuarios = new ArrayList<>();
        Optional<Usuarios> usuario;
        try{
            TypedQuery<Usuarios> queryUser = entityManager.createQuery("FROM usuarios WHERE email = :email", Usuarios.class);
            queryUser.setParameter("email", email);
            usuarios = queryUser.getResultList();
        } catch (Exception e) {
            String ex = e.getLocalizedMessage();
        }
        return usuario = Optional.ofNullable(usuarios.get(0));
    }

    @Override
    public List<Usuarios> getAll() {
        List<Usuarios> usuarios = new ArrayList<>();
        try {
            TypedQuery<Usuarios> queryUsers = entityManager.createQuery("FROM usuarios ", Usuarios.class);
            usuarios = queryUsers.getResultList();
        } catch (Exception e){
            String ex = e.getLocalizedMessage();
        }
        return usuarios;
    }

    @Override
    @Transactional
    public Usuarios save(Usuarios usuarios) {
        try{
            entityManager.persist(usuarios);
        } catch (Exception e) {
            String ex = e.getLocalizedMessage();
            System.out.println(ex);
        }
        return usuarios;
    }
}
