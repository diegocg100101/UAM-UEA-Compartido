/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uam.UamCompartido.Controller;

import com.uam.UamCompartido.DAO.TrimestreDAOImplementation;
import com.uam.UamCompartido.DAO.TroncoDAOImplementation;
import com.uam.UamCompartido.DAO.UeaDAOImplementation;
import com.uam.UamCompartido.DAO.UnidadDAOImplementation;
import com.uam.UamCompartido.JPA.Trimestre;
import com.uam.UamCompartido.JPA.Tronco;
import com.uam.UamCompartido.JPA.UEA;
import com.uam.UamCompartido.JPA.Unidad;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 *
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
    
    @GetMapping("/ListadoUEA")
    public String ListaUEA(Model model){
        List<UEA> ueas = ueaDAOImplementation.GetAll();
        model.addAttribute("ueas", ueas);
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
        return "form";
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
        List<Unidad>unidades = unidadDAOImplementation.GetAll();
        model.addAttribute("unidades",unidades);

        List<Tronco>troncos = troncoDAOImplementation.GetAll();
        model.addAttribute("troncos",troncos);

        List<Trimestre>trimestres = trimestreDAOImplementation.GetAll();
        model.addAttribute("trimestres",trimestres);

        model.addAttribute("uea",uea);

        return "form";
    }

    @PostMapping("/AgregarUEA")
    public String AddUEA(@ModelAttribute("uea") UEA uea){
        ueaDAOImplementation.Add(uea);
        return "redirect:/UEA/ListadoUEA";
    }

    @GetMapping("/BuscarUEA")
    public String BuscarUEA(@RequestParam("busqueda") String clave, Model model){
        UEA uea = ueaDAOImplementation.GetByClave(clave);
        model.addAttribute("ueas", uea);
        return "listUEA";
    }

    @GetMapping("/BuscarUEAPorNombre")
    public String BuscarNOMBRE(@RequestParam("nombre") String nombre, Model model){
        List<UEA> ueas = ueaDAOImplementation.GetByNombre(nombre);
        model.addAttribute("ueas", ueas);
        return "listUEA";
    }


}
