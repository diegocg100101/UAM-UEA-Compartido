package com.uam.UamCompartido.Services;

import com.uam.UamCompartido.DAO.AlumnosDAOImplementation;
import com.uam.UamCompartido.DAO.ProfesoresDAOImplementation;
import com.uam.UamCompartido.DAO.UsuariosDAOImplementation;
import com.uam.UamCompartido.DTO.LoginUserDTO;
import com.uam.UamCompartido.DTO.SignupUserDTO;
import com.uam.UamCompartido.Model.*;
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
    private final AlumnosDAOImplementation alumnosDAOImplementation;
    private final UsuariosDAOImplementation usuarioDAO;
    private final AuthenticationManager authenticationManager;

    @Autowired
    private ProfesoresDAOImplementation profesoresDAOImplementation;
    @Autowired
    private UsuariosDAOImplementation usuariosDAOImplementation;

    public AuthService(PasswordEncoder passwordEncoder, ProfesoresDAOImplementation profesoresDAO, AlumnosDAOImplementation alumnosDAOImplementation, UsuariosDAOImplementation usuarioDAO, AuthenticationManager authenticationManager) {
        this.passwordEncoder = passwordEncoder;
        this.profesoresDAO = profesoresDAO;
        this.alumnosDAOImplementation = alumnosDAOImplementation;
        this.usuarioDAO = usuarioDAO;
        this.authenticationManager = authenticationManager;
    }

    // Dar de alta profesores

    /*
    public Profesores signupProfesores(SignupUserDTO input){
        Profesores profesor = new Profesores();
        profesor.setNoEconomico(input.getNoEconomico());
        profesor.setNombre(input.getNombre());
        profesor.setApellidoMaterno(input.getApellidoMaterno());
        profesor.setApellidoPaterno(input.getApellidoPaterno());
        profesor.setUnidad(entityManager.find(Unidad.class, input.getIdUnidad()));
        profesor.setDepartamento(entityManager.find(Departamento.class, input.getIdDepartamento()));
        profesor.setDivision(entityManager.find(Division.class, input.getIdDivision()));
        return profesoresDAO.save(profesor);
    }
    */

    // signup
    public Usuarios signup(SignupUserDTO input){
        Usuarios usuario = new Usuarios();
        usuario.setEmail(input.getEmail());
        usuario.setPassword(passwordEncoder.encode(input.getPassword()));
        usuario.setNoEconomico(input.getNoEconomico().isEmpty() ? null : input.getNoEconomico());
        usuario.setNombre(input.getNombre());
        usuario.setApellidoMaterno(input.getApellidoMaterno());
        usuario.setApellidoPaterno(input.getApellidoPaterno());
        usuario.setUnidad(entityManager.find(Unidad.class, input.getIdUnidad()));
        usuario.setDepartamento(entityManager.find(Departamento.class, input.getIdDepartamento()));
        usuario.setDivision(entityManager.find(Division.class, input.getIdDivision()));
        usuario.setRol(entityManager.find(Roles.class, 1));

        /*if(input.getNoEconomico() == null){
            Alumnos alumno = new Alumnos();
            alumno.setMatricula(input.getMatricula());
            alumno.setNombre(input.getNombre());
            alumno.setApellidoPaterno(input.getApellidoPaterno());
            alumno.setApellidoMaterno(input.getApellidoMaterno());
            alumno.setCarrera(entityManager.find(Carrera.class, input.getIdCarrera()));
            alumno.setDivision(entityManager.find(Division.class, input.getIdDivision()));
            alumno.setUnidad(entityManager.find(Unidad.class, input.getIdUnidad()));
            alumnosDAOImplementation.save(alumno);

            usuario.setRol(entityManager.find(Roles.class, 1));
            usuario.setClave(input.getMatricula());
            usuario.setTipo("alumno");
        } else if(input.getMatricula() == null) {
            Profesores profesor = new Profesores();
            profesor.setNoEconomico(input.getNoEconomico());
            profesor.setNombre(input.getNombre());
            profesor.setApellidoMaterno(input.getApellidoMaterno());
            profesor.setApellidoPaterno(input.getApellidoPaterno());
            profesor.setUnidad(entityManager.find(Unidad.class, input.getIdUnidad()));
            profesor.setDepartamento(entityManager.find(Departamento.class, input.getIdDepartamento()));
            profesor.setDivision(entityManager.find(Division.class, input.getIdDivision()));
            profesoresDAOImplementation.save(profesor);

            usuario.setRol(entityManager.find(Roles.class, 1));
            usuario.setClave(input.getNoEconomico());
            usuario.setTipo("profesor");
        }*/
        return usuariosDAOImplementation.save(usuario);
    }

    public Usuarios authenticate(LoginUserDTO input){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()
                )
        );
        return usuarioDAO.findByEmail(input.getEmail()).orElseThrow();
    }
}
