package com.example.voluntariado_p2sem.controller;

import com.example.voluntariado_p2sem.dto.UsuarioDTO;
import com.example.voluntariado_p2sem.jpa.repositories.ActividadIRep;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/panel")
public class PanelController {

    @Autowired
    private ActividadIRep actividadIRep;

    // Inicio general (página principal)
    @GetMapping("/inicio")
    public String inicio(Model model) {
        model.addAttribute("actividades",
                actividadIRep.findAll());
        return "index";
    }

    @GetMapping("/admin")
    public String panelAdmin(Model model, HttpSession httpSession) {
        UsuarioDTO usuario = (UsuarioDTO) httpSession.getAttribute("usuarioActual");
        if (usuario == null) {
            return "redirect:/auth/login";
        }
        model.addAttribute("usuario", usuario);
        return "panels/admin/panelAdmin";           // /WEB-INF/views/panelAdmin.jsp
    }
    @GetMapping("/indexAdmin")
    public String indexAdmin(HttpSession httpSession, Model model ) {
        UsuarioDTO usuario = (UsuarioDTO) httpSession.getAttribute("usuarioActual");
        if (usuario == null) {
            return "redirect:/auth/login";
        }
        model.addAttribute("usuario", usuario);
        model.addAttribute("actividades",
                actividadIRep.findAll());
        return "panels/admin/indexAdmin";
    }

    @GetMapping("/rh")
    public String panelRh(Model model, HttpSession httpSession) {
        UsuarioDTO usuario = (UsuarioDTO) httpSession.getAttribute("usuarioActual");
        if (usuario == null) {
            return "redirect:/auth/login";
        }
        model.addAttribute("usuario", usuario);
        return "panels/rh/panelRH";              // /WEB-INF/views/panelRH.jsp
    }
    @GetMapping("/indexRH")
    public String indexRH(Model model, HttpSession httpSession) {
        UsuarioDTO usuario = (UsuarioDTO) httpSession.getAttribute("usuarioActual");
        if (usuario == null) {
            return "redirect:/auth/login";
        }
        model.addAttribute("usuario", usuario);
        model.addAttribute("actividades",
                actividadIRep.findAll());
        return "panels/rh/indexRH";
    }

    @GetMapping("/trabajador")
    public String panelTrabajador(Model model, HttpSession httpSession) {
        UsuarioDTO usuario = (UsuarioDTO) httpSession.getAttribute("usuarioActual");
        if (usuario == null) {
            return "redirect:/auth/login";
        }
        model.addAttribute("usuario", usuario);
        return "panels/trabajador/panelTrabajador";      // /WEB-INF/views/panelTrabajador.jsp
    }
    @GetMapping("/indexTrabajador")
    public String indexTrabajador(Model model, HttpSession httpSession) {
        UsuarioDTO usuario = (UsuarioDTO) httpSession.getAttribute("usuarioActual");
        if (usuario == null) {
            return "redirect:/auth/login";
        }
        model.addAttribute("usuario", usuario);
        model.addAttribute("actividades",
                actividadIRep.findAll());
        return "panels/trabajador/indexTrabajador";
    }

    @GetMapping("/equipo")
    public String panelEquipoOperativo(Model model, HttpSession httpSession) {
        UsuarioDTO usuario = (UsuarioDTO) httpSession.getAttribute("usuarioActual");
        if (usuario == null) {
            return "redirect:/auth/login";
        }
        model.addAttribute("usuario", usuario);
        return "panels/equipoOper/panelEquipoOper";      // /WEB-INF/views/PanelEquipoOper.jsp
    }
    @GetMapping("/indexEquipoOper")
    public String indexEquipoOper(Model model, HttpSession httpSession) {
        UsuarioDTO usuario = (UsuarioDTO) httpSession.getAttribute("usuarioActual");
        if (usuario == null) {
            return "redirect:/auth/login";
        }
        model.addAttribute("usuario", usuario);
        model.addAttribute("actividades",
                actividadIRep.findAll());
        return "panels/equipoOper/indexEquipoOp";
    }

// Lo mismo para indexRH, indexEquipoOper, indexTrabajador

}
