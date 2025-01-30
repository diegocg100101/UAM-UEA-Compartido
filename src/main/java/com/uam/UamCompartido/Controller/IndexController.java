/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uam.UamCompartido.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author LGMX
 */

@Controller
@RequestMapping
public class IndexController {
    
    @GetMapping
    public String Index(Model model){
        return "index";
    }

    @GetMapping("/AcercaDe")
    public String AcercaDe(Model model){
        return "acercade";
    }

}
