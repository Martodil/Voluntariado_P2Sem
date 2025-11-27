package com.example.voluntariado_p2sem.controller;

import com.example.voluntariado_p2sem.fbo.RegistroUsuarioFrm;
import com.example.voluntariado_p2sem.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/auth")   // TODAS las rutas de aquí van con /auth delante
public class RegistroUsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // GET /auth/registro  -> muestra el formulario
    @GetMapping("/registro")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("registroUsuarioFrm", new RegistroUsuarioFrm());
        return "auth/registro";     // /WEB-INF/views/registro.jsp
    }

    // POST /auth/registro -> procesa el formulario
    @PostMapping("/registro")
    public String procesarRegistro(
            @Valid @ModelAttribute("registroUsuarioFrm") RegistroUsuarioFrm frm,
            BindingResult result,
            RedirectAttributes redirect) {

        if (result.hasErrors()) {
            return "auth/registro";
        }

        try {
            usuarioService.registrarNuevoUsuario(frm);

            redirect.addFlashAttribute(
                    "mensajeExito",
                    "El usuario fue registrado correctamente. Ahora puedes iniciar sesión."
            );

            // MUY IMPORTANTE: redirect RELATIVO
            // Como estamos en /auth/registro, "redirect:login"
            // se convierte en /auth/login (Spring agrega el contextPath solo).
            return "redirect:login";

        } catch (Exception ex) {
            result.reject("error.global", ex.getMessage());
            return "auth/registro";
        }
    }
}
