package com.uam.UamCompartido.Services;

import com.uam.UamCompartido.DAO.UsuariosDAOImplementation;
import com.uam.UamCompartido.Model.Usuarios;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author diego
 */

@Service
public class UserService {
    private final UsuariosDAOImplementation usuariosDAOImplementation;

    public UserService(UsuariosDAOImplementation usuariosDAOImplementation) {
        this.usuariosDAOImplementation = usuariosDAOImplementation;
    }

    public List<Usuarios> allUsers() {
        return new ArrayList<>(usuariosDAOImplementation.getAll());
    }

}
