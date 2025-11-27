package com.example.voluntariado_p2sem.controller;

import com.example.voluntariado_p2sem.dto.UsuarioDTO;
import com.example.voluntariado_p2sem.fbo.LoginFrm;
import com.example.voluntariado_p2sem.services.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/auth")
public class LoginController {

    @Autowired
    private UsuarioService usuarioService;

    // GET /auth/login
    @GetMapping("/login")
    public String mostrarLogin(Model model) {
        model.addAttribute("loginFrm", new LoginFrm());
        return "auth/login";        // /WEB-INF/views/login.jsp
    }

    // POST /auth/login
    @PostMapping("/login")
    public String procesarLogin(
            @ModelAttribute("loginFrm") LoginFrm frm,
            HttpSession session,
            RedirectAttributes redirect) {

        UsuarioDTO usuario = usuarioService.validarLogin(frm);

        if (usuario == null) {
            redirect.addFlashAttribute("error", "Usuario o contraseña incorrectos.");
            // redirige de nuevo a /auth/login (relativo a /auth)
            return "redirect:login";
        }

        session.setAttribute("usuarioActual", usuario);
        // Redirecciones a paneles (estas sí pueden ir absolutas dentro del contexto)
        switch (usuario.getTipoUsuario()) {
            case "A":
                return "redirect:/panel/admin";
            case "R":
                return "redirect:/panel/rh";
            case "T":
                return "redirect:/panel/trabajador";
            case "E":
                return "redirect:/panel/equipo";
            default:
                return "redirect:login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session, RedirectAttributes redirect) {

        // Elimina todos los datos de sesión
        session.invalidate();

        // Redirige al login
        return "auth/logout";
    }
}
