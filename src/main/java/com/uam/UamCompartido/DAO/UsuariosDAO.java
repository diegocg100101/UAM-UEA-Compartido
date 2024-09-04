package com.uam.UamCompartido.DAO;

import com.uam.UamCompartido.JPA.Usuarios;

import java.util.List;
import java.util.Optional;

/**
 * @author diego
 */
public interface UsuariosDAO {
    public Optional<?> findByEmail(String email);

    public List<Usuarios> getAll();

    public Usuarios save(Usuarios usuarios);
}
