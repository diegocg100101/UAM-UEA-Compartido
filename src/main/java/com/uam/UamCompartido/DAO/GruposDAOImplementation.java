package com.uam.UamCompartido.DAO;

import com.uam.UamCompartido.JPA.Grupos;
import com.uam.UamCompartido.JPA.UEA;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class GruposDAOImplementation implements GruposDAO{

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public void GrupoAdd() {
        jdbcTemplate.execute("INSERT INTO grupos VALUES('123','510004',3,1,'255',10,45)");

    }

    @Override
    public Grupos GrupoGetByClave() {
        return null;
    }

    @Override
    public List<Grupos> GrupoGetAll() {
        return List.of();
    }

    @Override
    public void GrupoDelete() {

    }

    @Override
    public void GrupoUpdate() {

    }
}
