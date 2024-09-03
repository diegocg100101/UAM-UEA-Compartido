package com.uam.UamCompartido.Services;

import com.uam.UamCompartido.DAO.ProfesoresDAOImplementation;
import com.uam.UamCompartido.DAO.UsuariosDAOImplementation;
import com.uam.UamCompartido.DTO.LoginUserDTO;
import com.uam.UamCompartido.DTO.SignupUserDTO;
import com.uam.UamCompartido.JPA.Departamento;
import com.uam.UamCompartido.JPA.Division;
import com.uam.UamCompartido.JPA.Profesores;
import com.uam.UamCompartido.JPA.Unidad;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author diego
 */
@Service
public class AuthService {

    @Autowired
    private EntityManager entityManager;

    private final PasswordEncoder passwordEncoder;
    private final ProfesoresDAOImplementation profesoresDAO;
    private final UsuariosDAOImplementation usuarioDAO;
    private final AuthenticationManager authenticationManager;

    public AuthService(PasswordEncoder passwordEncoder, ProfesoresDAOImplementation profesoresDAO, UsuariosDAOImplementation usuarioDAO, AuthenticationManager authenticationManager) {
        this.passwordEncoder = passwordEncoder;
        this.profesoresDAO = profesoresDAO;
        this.usuarioDAO = usuarioDAO;
        this.authenticationManager = authenticationManager;
    }

    // Dar de alta profesores
    public Profesores signupProfesores(SignupUserDTO input){
        Profesores profesor = new Profesores();
        profesor.setNoEconomico(input.getNoEconomico());
        profesor.setNombre(input.getNombre());
        profesor.setEmail(input.getEmail());
        profesor.setPassword(passwordEncoder.encode(input.getPassword()));
        profesor.setApellidoMaterno(input.getApellidoMaterno());
        profesor.setApellidoPaterno(input.getApellidoPaterno());
        profesor.setUnidad(entityManager.find(Unidad.class, input.getIdUnidad()));
        profesor.setDepartamento(entityManager.find(Departamento.class, input.getIdDepartamento()));
        profesor.setDivision(entityManager.find(Division.class, input.getIdDivision()));


        return profesoresDAO.save(profesor);
    }

    // Dar de alta alumnos


    public Profesores authenticate(LoginUserDTO input){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()
                )
        );
        return profesoresDAO.findByEmail(input.getEmail()).orElseThrow();
    }
}
