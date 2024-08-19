package com.uam.UamCompartido.Services;

import com.uam.UamCompartido.DAO.ProfesoresDAOImplementation;
import com.uam.UamCompartido.DTO.LoginUserDTO;
import com.uam.UamCompartido.DTO.SignupUserDTO;
import com.uam.UamCompartido.JPA.Profesores;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author diego
 */
public class AuthService {

    private final PasswordEncoder passwordEncoder;
    private final ProfesoresDAOImplementation profesoresDAO;
    private final AuthenticationManager authenticationManager;

    public AuthService(PasswordEncoder passwordEncoder, ProfesoresDAOImplementation profesoresDAO, AuthenticationManager authenticationManager) {
        this.passwordEncoder = passwordEncoder;
        this.profesoresDAO = profesoresDAO;
        this.authenticationManager = authenticationManager;
    }

    public Profesores signup(SignupUserDTO input){
        Profesores profesor = new Profesores();
        profesor.setNombre(input.getNombre());
        profesor.setEmail(input.getEmail());
        profesor.setPassword(passwordEncoder.encode(input.getPassword()));

        return profesor;
    }

    public Profesores authenticate(LoginUserDTO input){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()
                )
        );
        return profesoresDAO.findByNoEconomico(input.getEmail()).orElseThrow();
    }
}
