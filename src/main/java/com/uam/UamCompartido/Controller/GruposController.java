package com.uam.UamCompartido.Controller;




import com.uam.UamCompartido.Model.Grupos;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author diego
 */
@Controller
@RequestMapping("/grupos")
public class GruposController {

    @GetMapping("/add")
    public String addGrupos(Grupos grupos) {
        return "grupos";
    }
}
