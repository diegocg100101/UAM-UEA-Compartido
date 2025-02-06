package com.uam.UamCompartido.DAO;

import com.uam.UamCompartido.Model.Usuarios;

import java.util.List;
import java.util.Optional;

/**
 * @author diego
 */
public interface UsuariosDAO {

    public Usuarios getByNumero(String numero);

    public Optional<?> findByEmail(String email);

    public List<Usuarios> getAll();

    public Usuarios save(Usuarios usuarios);


}
