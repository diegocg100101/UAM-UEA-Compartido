package com.uam.UamCompartido.Controller;

import com.uam.UamCompartido.DTO.LoginProfesoresDTO;
import com.uam.UamCompartido.DTO.SignupProfesoresDTO;
import com.uam.UamCompartido.JPA.Profesores;
import com.uam.UamCompartido.Responses.LoginResponse;
import com.uam.UamCompartido.Services.AuthService;
import com.uam.UamCompartido.Services.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author diego
 */
@Controller
@RequestMapping("/auth")
public class AuthController {

    private final JwtService jwtService;
    private final AuthService authService;

    public AuthController(JwtService jwtService, AuthService authService) {
        this.jwtService = jwtService;
        this.authService = authService;
    }

    @GetMapping("/signup")
    public String register(){
        return "index";
    }

    @PostMapping("/signup")
    public ResponseEntity<Profesores> register(@RequestBody SignupProfesoresDTO signupUserDTO){
        Profesores profesorRegistrado = authService.signup(signupUserDTO);

        return ResponseEntity.ok(profesorRegistrado);
    }

    @GetMapping("/login")
    public String login(){
        return "signupProfesores";
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginProfesoresDTO loginUserDTO){
        Profesores profesoresAutenticado = authService.authenticate(loginUserDTO);
        String jwtToken = jwtService.generateToken(profesoresAutenticado);

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());

        return ResponseEntity.ok(loginResponse);
    }

}
