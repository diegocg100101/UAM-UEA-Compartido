package com.uam.UamCompartido.Controller;




import com.uam.UamCompartido.DAO.*;
import com.uam.UamCompartido.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author diego
 */
@Controller
@RequestMapping("/grupos")
public class GruposController {

    @Autowired
    GruposDAO gruposDAOImplementation;

    @Autowired
    UeaDAOImplementation ueaDAOImplementation;

    @Autowired
    UnidadDAOImplementation unidadDAOImplementation;

    @Autowired
    HorarioDAOImplementation horarioDAOImplementation;

    @Autowired
    ProfesoresDAOImplementation profesoresDAOImplementation;

    @Autowired
    SalonDAOImplementation salonDAOImplementation;

    @GetMapping("/add")
    public String addGrupos(Model  model) {
        Grupos grupo = new Grupos();

        List<UEA> ueas = ueaDAOImplementation.GetAll();
        model.addAttribute("ueas", ueas);

        List<Unidad> unidades = unidadDAOImplementation.GetAll();
        model.addAttribute("unidades", unidades);

        List<Horario> horarios = horarioDAOImplementation.GetAllHorario();
        model.addAttribute("horarios", horarios);

        List<Profesores> profesores = profesoresDAOImplementation.GetAll();
        model.addAttribute("profesores", profesores);

        List<Salon> salones = salonDAOImplementation.GetAllSalon();
        model.addAttribute("salones", salones);

        model.addAttribute("grupo", grupo);
        return "grupos";
    }

    @PostMapping("/add")
    public String addGrupo(@ModelAttribute("grupo") Grupos grupo, Model model) {
        try {
            gruposDAOImplementation.Save(grupo);
            return "redirect:/grupos/add";
        } catch (Exception e) {
            model.addAttribute("erro", "Alta incorrecta, verifica los campos");
            return "redirect:/grupos/add";
        }
    }

    @GetMapping("/list")
    public String ListarGrupos(Model model) {
        List<Grupos> grupos = gruposDAOImplementation.GetAll();
        model.addAttribute("grupos", grupos);
        return "listGrupo";
    }
}
