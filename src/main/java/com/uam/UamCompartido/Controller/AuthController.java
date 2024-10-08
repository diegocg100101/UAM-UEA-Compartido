package com.uam.UamCompartido.Controller;

import com.uam.UamCompartido.DAO.CarreraDAOImplementation;
import com.uam.UamCompartido.DAO.DepartamentoDAOImplementation;
import com.uam.UamCompartido.DAO.DivisionDAOImplementation;
import com.uam.UamCompartido.DAO.UnidadDAOImplementation;
import com.uam.UamCompartido.DTO.LoginUserDTO;
import com.uam.UamCompartido.DTO.SignupUserDTO;
import com.uam.UamCompartido.JPA.*;
import com.uam.UamCompartido.Responses.LoginResponse;
import com.uam.UamCompartido.Services.AuthService;
import com.uam.UamCompartido.Services.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author diego
 */
@Controller
@RequestMapping("/auth")
public class AuthController {

    private final JwtService jwtService;
    private final AuthService authService;

    @Autowired
    private UnidadDAOImplementation unidadDAOImplementation;

    @Autowired
    private DivisionDAOImplementation divisionDAOImplementation;

    @Autowired
    private DepartamentoDAOImplementation departamentoDAOImplementation;

    @Autowired
    private CarreraDAOImplementation carreraDAOImplementation;

    public AuthController(JwtService jwtService, AuthService authService) {
        this.jwtService = jwtService;
        this.authService = authService;
    }

    @GetMapping("/signup")
    public String register(Model model){
        model.addAttribute("user", new SignupUserDTO());

        List<Unidad> unidades = unidadDAOImplementation.GetAll();
        model.addAttribute("unidades",unidades);

        List<Division> divisiones = divisionDAOImplementation.GetAll();
        model.addAttribute("divisiones", divisiones);

        List<Departamento> departamentos = departamentoDAOImplementation.getDepartamentos();
        model.addAttribute("departamentos", departamentos);

        List<Carrera> carreras = carreraDAOImplementation.GetAll();
        model.addAttribute("carreras", carreras);

        return "signup";
    }

    @PostMapping("/signup")
    public String register(@ModelAttribute("user") SignupUserDTO signupUserDTO){
        Usuarios usuariosRegistrado = authService.signup(signupUserDTO);
        return "redirect:/auth/signup";
    }

    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("userLogin", new LoginUserDTO());
        return "login";
    }

    @PostMapping("/login")
    public String authenticate(@ModelAttribute("userLogin") LoginUserDTO loginUserDTO, Model model){
        Usuarios usuariosAutenticado = authService.authenticate(loginUserDTO);
        String jwtToken = jwtService.generateToken(usuariosAutenticado);

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());

        model.addAttribute("token", jwtToken);
        return "redirect:/";
    }

}
