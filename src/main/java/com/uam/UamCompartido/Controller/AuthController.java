package com.uam.UamCompartido.Controller;

import com.uam.UamCompartido.DAO.CarreraDAOImplementation;
import com.uam.UamCompartido.DAO.DepartamentoDAOImplementation;
import com.uam.UamCompartido.DAO.DivisionDAOImplementation;
import com.uam.UamCompartido.DAO.UnidadDAOImplementation;
import com.uam.UamCompartido.DTO.LoginUserDTO;
import com.uam.UamCompartido.DTO.SignupUserDTO;
import com.uam.UamCompartido.Model.*;
import com.uam.UamCompartido.Services.AuthService;
import com.uam.UamCompartido.Services.JwtService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String register(@ModelAttribute("user") SignupUserDTO signupUserDTO, Model model,
                           RedirectAttributes redirectAttributes){
        try {
            Usuarios usuariosRegistrado = authService.signup(signupUserDTO);
            redirectAttributes.addFlashAttribute("success", "Registro exitoso");
            return "redirect:/auth/signup";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("err", "Verifique los campos" );
            return "redirect:/auth/signup";
        }
    }

    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("userLogin", new LoginUserDTO());
        return "login";
    }

    @PostMapping("/login")
    public String authenticate(@ModelAttribute("userLogin") LoginUserDTO loginUserDTO, HttpServletResponse response, Model model) {
        try {
            Usuarios usuariosAutenticado = authService.authenticate(loginUserDTO);
            String jwtToken = jwtService.generateToken(usuariosAutenticado);
            Cookie cookie = new Cookie("jwt", jwtToken);
            cookie.setHttpOnly(true);
            cookie.setSecure(true);
            cookie.setPath("/");
            response.addCookie(cookie);
            return "redirect:/";
        } catch (Exception e) {
            model.addAttribute("error", "Autenticación incorrecta");
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpServletResponse response){
        Cookie cookie = new Cookie("jwt", null);
        cookie.setMaxAge(0);
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        response.addCookie(cookie);

        return "redirect:/";
    }
}
