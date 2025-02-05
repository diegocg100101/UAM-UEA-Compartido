package com.uam.UamCompartido.Controller;

import com.uam.UamCompartido.Model.Usuarios;
import com.uam.UamCompartido.Services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author diego
 */

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/me")
    public String authenticatedUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Usuarios usuario = (Usuarios)authentication.getPrincipal();

        return "user";
    }

    @GetMapping("/")
    public ResponseEntity<List<Usuarios>> allUsers(){
        List<Usuarios> usuarios = userService.allUsers();

        return ResponseEntity.ok(usuarios);
    }
}
