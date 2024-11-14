package com.uam.UamCompartido.Controller;

import com.uam.UamCompartido.DAO.*;
import com.uam.UamCompartido.Editor.HorarioEditor;
import com.uam.UamCompartido.Editor.*;
import com.uam.UamCompartido.JPA.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/Grupos")
public class GruposController {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private GruposDAOImplementation gruposDAOImplementation;

    @Autowired
    private UnidadDAOImplementation unidadDAOImplementation;

    @Autowired
    private ProfesoresDAOImplementation profesoresDAOImplementation;

    @Autowired
    private HorarioDAOImplementation horarioDAOImplementation;

    @Autowired
    private SalonDAOImplementation salonDAOImplementation;

    @Autowired
    private UeaDAOImplementation ueaDAOImplementation;

    @GetMapping
    public String grupos(Model model) {
        return "grupos";
    }

    @GetMapping("/ListadoGrupos")
    public String ListarGrupos(Model model) {
        List<Grupos> grupo = gruposDAOImplementation.GrupoGetAll();
        model.addAttribute("grupo", grupo);
        return "listGrupo";
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
    public String AgregarGrupos(Model model) {

        Grupos grupo = new Grupos();

        List<Unidad> unidades = unidadDAOImplementation.GetAll();
        model.addAttribute("unidades",unidades);

        List<Horario> horarios = horarioDAOImplementation.GetAllHorario();
        model.addAttribute("horarios",horarios);

        List<Profesores> profesor = profesoresDAOImplementation.GetAll();
        model.addAttribute("profesor",profesor);

        List<Salon> salones = salonDAOImplementation.GetAllSalon();
        model.addAttribute("salones", salones);

        List<UEA> ueas = ueaDAOImplementation.GetAll();
        model.addAttribute("ueas", ueas);

        model.addAttribute("grupo", grupo);

        return "grupos";
    }


    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Horario.class, new HorarioEditor());

        //binder.registerCustomEditor(Profesores.class, profesoresEditor);
        //binder.registerCustomEditor(Profesores.class, "no_economico", profesoresEditor);
        //binder.registerCustomEditor(Profesores.class, new ProfesoresEditor());
    }

    @PostMapping("/AgregarGrupos")
    public String AgregarGrupos(@ModelAttribute("grupo") Grupos grupo){
        try {
            gruposDAOImplementation.save(grupo);
        } catch (Exception e) {
            e.printStackTrace();
            return "error"; // Puedes crear una vista para mostrar errores si prefieres
        }
        return "redirect:/Grupos/ListadoGrupos";
    }


}

/*
        grupo.setClave_grupo(entityManager.toString());
        grupo.setUnidad(entityManager.find(Unidad.class, 1));
        grupo.setHorario(entityManager.find(Horario.class, 1));
        grupo.setNo_economico(entityManager.find(Profesores.class,1));
        grupo.setSalon(entityManager.find(Salon.class, 1));*/
// gruposDAOImplementation.save(grupo);
