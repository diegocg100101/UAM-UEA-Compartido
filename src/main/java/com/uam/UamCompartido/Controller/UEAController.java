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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @GetMapping("/EditarUEA")
    public String EditarUEA(){
        return "UEA";
    }

    @GetMapping("/EliminarUEA")
    public String EliminarUEA(Model model){
        UEA uea = new UEA();
        model.addAttribute("uea", uea);
        return "deleteUEA";
    }

    @PostMapping("/EliminarUEA")
    public String EliminarUEA(@ModelAttribute("clave") String clave){
        ueaDAOImplementation.Delete(clave);
        return "deleteUEA";
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
    
}
