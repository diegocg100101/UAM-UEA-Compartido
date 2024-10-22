package com.uam.UamCompartido.Controller;

import com.uam.UamCompartido.DAO.GruposDAOImplementation;
import com.uam.UamCompartido.JPA.Grupos;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Grupos")
public class GruposController {

    @Autowired
    private GruposDAOImplementation gruposDAOImplementation;

    @GetMapping
    public String grupos(Model model) {
        return "grupos";
    }

    @GetMapping("/ListadoGrupos")
    public String ListarGrupos(Model model) {
        return "grupos";
    }

    @GetMapping("/EditarGrupos")
    public String EditarGrupos(Model model) {
        return "grupos";
    }

    @GetMapping("/EliminarGrupos")
    public String EliminarGrupos(Model model) {
        return "grupos";
    }

    @GetMapping("/AgregarGrupos")
    public String AgregarGrupos() {
        gruposDAOImplementation.GrupoAdd();
        return "grupos";
    }


}
