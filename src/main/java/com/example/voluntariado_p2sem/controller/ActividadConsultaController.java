package com.example.voluntariado_p2sem.controller;

import com.example.voluntariado_p2sem.jpa.model.Actividad;
import com.example.voluntariado_p2sem.jpa.repositories.ActividadIRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ActividadConsultaController {

    @Autowired
    private ActividadIRep actividadIRep;

    @GetMapping("/actividades")
    public String verActividades(Model model) {
        List<Actividad> actividades = actividadIRep.findAll();
        model.addAttribute("actividades", actividades);
        return "/listaActividades.jsp";   // /WEB-INF/views/actividades/lista.jsp
    }
}
