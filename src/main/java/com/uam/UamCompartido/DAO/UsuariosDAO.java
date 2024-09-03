package com.uam.UamCompartido.DAO;

import java.util.Optional;

/**
 * @author diego
 */
public interface UsuariosDAO {
    public Optional<?> findByEmail(String email);
}
