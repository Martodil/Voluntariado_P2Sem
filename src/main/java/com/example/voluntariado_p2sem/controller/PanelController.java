package com.example.voluntariado_p2sem.controller;

import com.example.voluntariado_p2sem.dto.UsuarioDTO;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/panel")
public class PanelController {

    @GetMapping("/admin")
    public String panelAdmin(Model model, HttpSession httpSession) {
        UsuarioDTO usuario = (UsuarioDTO) httpSession.getAttribute("usuarioActual");
        if (usuario == null) {
            return "redirect:/auth/login";
        }
        model.addAttribute("usuario", usuario);
        return "panelAdmin";           // /WEB-INF/views/panelAdmin.jsp
    }

    @GetMapping("/rh")
    public String panelRh(Model model, HttpSession httpSession) {
        UsuarioDTO usuario = (UsuarioDTO) httpSession.getAttribute("usuarioActual");
        if (usuario == null) {
            return "redirect:/auth/login";
        }
        model.addAttribute("usuario", usuario);
        return "panelRH";              // /WEB-INF/views/panelRH.jsp
    }

    @GetMapping("/trabajador")
    public String panelTrabajador(Model model, HttpSession httpSession) {
        UsuarioDTO usuario = (UsuarioDTO) httpSession.getAttribute("usuarioActual");
        if (usuario == null) {
            return "redirect:/auth/login";
        }
        model.addAttribute("usuario", usuario);
        return "panelTrabajador";      // /WEB-INF/views/panelTrabajador.jsp
    }

    @GetMapping("/equipo")
    public String panelEquipoOperativo(Model model, HttpSession httpSession) {
        UsuarioDTO usuario = (UsuarioDTO) httpSession.getAttribute("usuarioActual");
        if (usuario == null) {
            return "redirect:/auth/login";
        }
        model.addAttribute("usuario", usuario);
        return "panelEquipoOper";      // /WEB-INF/views/PanelEquipoOper.jsp
    }
}
