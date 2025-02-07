package com.uam.UamCompartido.Controller;




import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.uam.UamCompartido.DAO.*;
import com.uam.UamCompartido.DTO.HorarioDTO;
import com.uam.UamCompartido.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author diego
 */
@Controller
@RequestMapping("/grupos")
public class GruposController {

    @Autowired
    GruposDAOImplementation gruposDAOImplementation;

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

    @Autowired
    UsuariosDAOImplementation usuariosDAOImplementation;

    @GetMapping("/add")
    public String addGrupos(Model model) {
        Grupos grupo = new Grupos();

        List<UEA> ueas = ueaDAOImplementation.GetAll();
        model.addAttribute("ueas", ueas);

        List<Unidad> unidades = unidadDAOImplementation.GetAll();
        model.addAttribute("unidades", unidades);

        List<Usuarios> usuarios = usuariosDAOImplementation.getAll();
        model.addAttribute("usuarios", usuarios);

        List<Salon> salones = salonDAOImplementation.GetAllSalon();
        model.addAttribute("salones", salones);

        model.addAttribute("grupo", grupo);

        List<String> dias = Arrays.asList("Lunes", "Martes", "Miércoles", "Jueves", "Viernes");
        model.addAttribute("dias", dias);

        List<String> horas = Arrays.asList("08:00 - 09:30", "09:30 - 11:00", "11:00 - 12:30", "12:30-14:00", "14:00 - 15:30", "15:30 - 17:00", "17:00 - 19:00");
        model.addAttribute("horas", horas);

        return "grupos";
    }

    @PostMapping("/add")
    public String addGrupo(@ModelAttribute("grupo") Grupos grupo, Model model, RedirectAttributes redirectAttributes) {
        try {
            grupo.convertirHorarioAJson();
            gruposDAOImplementation.Save(grupo);
            redirectAttributes.addFlashAttribute("succ", "Alta exitosa");
            return "redirect:/grupos/add";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("erro", "Alta incorrecta, verifica los campos");
            return "redirect:/grupos/add";
        }
    }

    @GetMapping("/list")
    public String ListarGrupos(Model model) {
        List<Grupos> grupos = gruposDAOImplementation.GetAll();
        model.addAttribute("grupos", grupos);
        return "listGrupo";
    }

    @GetMapping("/delete/{clave}")
    public String EliminarUEA(@PathVariable("clave") String clave, RedirectAttributes redirectAttributes) {
        try {
            gruposDAOImplementation.Delete(clave);
            redirectAttributes.addFlashAttribute("message", "Eliminado exitosa");
            return "redirect:/grupos/list";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", "Eliminado fallido");
            return "redirect:/grupos/list";
        }
    }

    @GetMapping("/edit/{clave}")
    public String editGrupos(@PathVariable("clave") String clave, Model model) {
        Grupos grupo = gruposDAOImplementation.GetByClave(clave);

        List<UEA> ueas = ueaDAOImplementation.GetAll();
        model.addAttribute("ueas", ueas);

        List<Unidad> unidades = unidadDAOImplementation.GetAll();
        model.addAttribute("unidades", unidades);

        List<Usuarios> usuarios = usuariosDAOImplementation.getAll();
        model.addAttribute("usuarios", usuarios);

        List<Salon> salones = salonDAOImplementation.GetAllSalon();
        model.addAttribute("salones", salones);

        model.addAttribute("grupo", grupo);

        List<String> dias = Arrays.asList("Lunes", "Martes", "Miércoles", "Jueves", "Viernes");
        model.addAttribute("dias", dias);

        List<String> horas = Arrays.asList("08:00 - 09:30", "09:30 - 11:00", "11:00 - 12:30", "12:30-14:00", "14:00 - 15:30", "15:30 - 17:00", "17:00 - 19:00");
        model.addAttribute("horas", horas);

        return "grupos";
    }

    @GetMapping("/horario/{clave}")
    public String horario(@PathVariable("clave") String clave, Model model) throws JsonProcessingException {
        Grupos grupo = gruposDAOImplementation.GetByClave(clave);

        ObjectMapper objectMapper = new ObjectMapper();
        List<HorarioDTO> horarioList;

        try {
            horarioList = objectMapper.readValue(grupo.getHorario(), new TypeReference<List<HorarioDTO>>() {});
        } catch (Exception e) {
            e.printStackTrace();
            horarioList = List.of(); // Si falla, asigna una lista vacía
        }

        List<String> dias = Arrays.asList("Lunes", "Martes", "Miércoles", "Jueves", "Viernes");
        model.addAttribute("dias", dias);

        List<String> horas = Arrays.asList("08:00 - 09:30", "09:30 - 11:00", "11:00 - 12:30", "12:30-14:00", "14:00 - 15:30", "15:30 - 17:00", "17:00 - 19:00");
        model.addAttribute("horas", horas);

        model.addAttribute("horarios", horarioList);
        model.addAttribute("grupo", grupo);

        return "horario";
    }
}
