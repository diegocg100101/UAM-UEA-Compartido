/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uam.UamCompartido.Controller;

import com.uam.UamCompartido.DAO.TrimestreDAOImplementation;
import com.uam.UamCompartido.DAO.TroncoDAOImplementation;
import com.uam.UamCompartido.DAO.UeaDAOImplementation;
import com.uam.UamCompartido.DAO.UnidadDAOImplementation;
import com.uam.UamCompartido.Model.*;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author LGMX
 */
@Controller
@RequestMapping("/UEA")
public class UEAController {
    
    @Autowired
    private UeaDAOImplementation ueaDAOImplementation;
    
    @Autowired
    private UnidadDAOImplementation unidadDAOImplementation;
    
    @Autowired
    private TroncoDAOImplementation troncoDAOImplementation;
    
    @Autowired
    private TrimestreDAOImplementation trimestreDAOImplementation;
    
    @GetMapping
    public String UEA(){
        return "UEA";
    }
    
    @GetMapping("/ListadoUEA/{filtro}")
    public String ListaUEA(@PathVariable("filtro") String filtro,  Model model){
        List<UEA> ueas = ueaDAOImplementation.GetAll();
        model.addAttribute("ueas", ueas);
        model.addAttribute("filtro", filtro);
        return "listUEA";
    }

    @GetMapping("/EditarUEA/{ClaveUEA}")
    public String EditarUEA(@PathVariable("ClaveUEA") String clave, Model model){
        UEA uea = ueaDAOImplementation.GetByClave(clave);
        model.addAttribute("uea", uea);

        List<Unidad>unidades = unidadDAOImplementation.GetAll();
        model.addAttribute("unidades",unidades);

        List<Tronco>troncos = troncoDAOImplementation.GetAll();
        model.addAttribute("troncos",troncos);

        List<Trimestre>trimestres = trimestreDAOImplementation.GetAll();
        model.addAttribute("trimestres",trimestres);

        model.addAttribute("uea",uea);
        return "formUEA";
    }

    @PostMapping("/EditarUEA/{ClaveUEA}")
    public String EditarUEA(@ModelAttribute("uea") UEA uea) {
        ueaDAOImplementation.Edit(uea);
        return "redirect:/UEA/ListadoUEA";
    }

    @GetMapping("/EliminarUEA/{ClaveUEA}")
    public String EliminarUEA(@PathVariable("ClaveUEA") String clave){
        ueaDAOImplementation.Delete(clave);
        return "redirect:/UEA/ListadoUEA";
    }

    @GetMapping("/AgregarUEA")
    public String AddUEA(Model model){

        UEA uea = new UEA();
        List<Unidad> unidades = unidadDAOImplementation.GetAll();
        model.addAttribute("unidades",unidades);

        List<Tronco> troncos = troncoDAOImplementation.GetAll();
        model.addAttribute("troncos",troncos);

        List<Trimestre> trimestres = trimestreDAOImplementation.GetAll();
        model.addAttribute("trimestres",trimestres);

        model.addAttribute("uea", uea);

        return "formUEA";
    }

    @PostMapping("/AgregarUEA")
    public String AddUEA(@ModelAttribute("uea") UEA uea, Model model, RedirectAttributes redirectAttributes){
        try {
            ueaDAOImplementation.Add(uea);
            return "redirect:/UEA/ListadoUEA/clave";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Verifique los campos");
            return "redirect:/UEA/AgregarUEA";
        }
    }

    @GetMapping("/BuscarUEA")
    public String BuscarUEA(@RequestParam("busqueda") String clave, Model model){
        List<UEA> ueas = ueaDAOImplementation.GetAllByClave(clave);
        model.addAttribute("ueas", ueas);
        model.addAttribute("filtro", "clave");
        return "listUEA";
    }

    @GetMapping("/BuscarUEAPorNombre")
    public String BuscarNOMBRE(@RequestParam("nombre") String nombre, Model model){
        List<UEA> ueas = ueaDAOImplementation.GetByNombre(nombre);
        model.addAttribute("ueas", ueas);
        model.addAttribute("filtro", "nombre");
        return "listUEA";
    }

}
