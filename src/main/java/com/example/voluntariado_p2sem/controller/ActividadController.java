package com.example.voluntariado_p2sem.controller;

import com.example.voluntariado_p2sem.dto.UsuarioDTO;
import com.example.voluntariado_p2sem.jpa.model.Actividad;
import com.example.voluntariado_p2sem.jpa.model.Inscripcion;
import com.example.voluntariado_p2sem.jpa.model.Usuario;
import com.example.voluntariado_p2sem.jpa.repositories.SedeIRep;
import com.example.voluntariado_p2sem.jpa.repositories.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/actividades")
public class ActividadController {

    @Autowired
    private ActividadIRep actividadIRep;

    @Autowired
    private InscripcionIRep inscripcionIRep;


    @Autowired
    private UsuarioIRep usuarioIRep;

    @Autowired
    private SedeIRep sedeIRep;

    @Autowired
    private SemestreIRep semestreIRep;

    @Autowired
    private TurnoIRep turnoIRep;

    // ======== LISTA GENERAL (se usa en inicio y paneles) ========
    @GetMapping("/lista")
    public String listarActividades(Model model) {
        List<Actividad> actividades =
                actividadIRep.findAll();
        model.addAttribute("actividades", actividades);
        return "actividades/listaActividades";
    }

    @GetMapping("/admin/lista")
    public String listarActividadesAdmin(Model model, HttpSession session) {

        UsuarioDTO usuario = (UsuarioDTO) session.getAttribute("usuarioActual");
        if (usuario == null) {
            return "redirect:/auth/login";
        }
        if (!"A".equalsIgnoreCase(usuario.getTipoUsuario())) {
            return "redirect:/actividades/lista"; // si no es admin, mándalo a la versión pública
        }

        model.addAttribute("usuario", usuario);
        model.addAttribute("actividades", actividadIRep.findAll());

        return "actividades/listaActividadesAdmin";
    }

    // ======== FORMULARIO NUEVA ACTIVIDAD (SOLO ADMIN) ========
    @GetMapping("/admin/nueva")
    public String mostrarFormNuevaActividad(Model model,
                                            HttpSession session,
                                            RedirectAttributes redirect) {

        UsuarioDTO usuario = (UsuarioDTO) session.getAttribute("usuarioActual");
        if (usuario == null) {
            return "redirect:/auth/login";
        }
        if (!"A".equalsIgnoreCase(usuario.getTipoUsuario())) {
            redirect.addFlashAttribute("mensajeError", "Solo el administrador puede crear actividades.");
            return "redirect:/actividades/admin/lista";
        }

        model.addAttribute("actividad", new Actividad());

        model.addAttribute("usuario", usuario);
        model.addAttribute("sedes", sedeIRep.findAll());
        model.addAttribute("semestres", semestreIRep.findAll());
        model.addAttribute("turnos", turnoIRep.findAll());

        return "actividades/formActividadAdmin";
    }

    @PostMapping("/admin/guardar")
    public String guardarActividad(@ModelAttribute("actividad") Actividad actividad,
                                   HttpSession session,
                                   RedirectAttributes redirect) {

        UsuarioDTO usuario = (UsuarioDTO) session.getAttribute("usuarioActual");
        if (usuario == null || !"A".equalsIgnoreCase(usuario.getTipoUsuario())) {
            redirect.addFlashAttribute("mensajeError", "No tienes permiso para registrar actividades.");
            return "redirect:/auth/login";
        }

        // Aquí ya viene todo llenito en 'actividad'
        actividadIRep.save(actividad);

        redirect.addFlashAttribute("mensajeOk", "Actividad registrada correctamente.");
        return "redirect:/actividades/admin/lista";
    }

    // TRABAJADOR
    @GetMapping("/trabajador/lista")
    public String listarActividadesTrabajador(Model model, HttpSession session) {
        UsuarioDTO usuario = (UsuarioDTO) session.getAttribute("usuarioActual");
        if (usuario == null) return "redirect:/auth/login";
        if (!"T".equalsIgnoreCase(usuario.getTipoUsuario())) {
            return "redirect:/actividades/lista";
        }
        model.addAttribute("usuario", usuario);
        model.addAttribute("actividades", actividadIRep.findAll());
        return "actividades/listaActividadesTrabajador";
    }

    // ======== INSCRIPCIÓN (SOLO TRABAJADOR) ========
    @PostMapping("/{idActividad}/inscribirse")
    public String inscribirse(@PathVariable("idActividad") Integer idActividad,
                              HttpSession session,
                              RedirectAttributes redirect) {

        UsuarioDTO usuarioDTO = (UsuarioDTO) session.getAttribute("usuarioActual");

        if (usuarioDTO == null) {
            return "redirect:/auth/login";
        }

        // Solo trabajadores
        if (!"T".equalsIgnoreCase(usuarioDTO.getTipoUsuario())) {
            redirect.addFlashAttribute("mensajeError", "Solo los trabajadores pueden inscribirse a actividades.");
            return "redirect:/actividades/trabajador/lista";
        }

        Usuario usuario = usuarioIRep.findById(usuarioDTO.getIdUsuario())
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));

        Actividad actividad = actividadIRep.findById(idActividad)
                .orElseThrow(() -> new IllegalArgumentException("Actividad no encontrada"));

        // Evitar doble inscripción
        if (inscripcionIRep.existsByUsuarioAndActividad(usuario, actividad)) {
            redirect.addFlashAttribute("mensajeError", "Ya estás inscrito en esta actividad.");
        } else {
            Inscripcion inscripcion = new Inscripcion();
            inscripcion.setUsuario(usuario);
            inscripcion.setActividad(actividad);
            inscripcion.setHorasInsc(0);
            inscripcion.setEstado("Activo");
            inscripcion.setFechaRegistro(LocalDate.now());

            inscripcionIRep.save(inscripcion);

            redirect.addFlashAttribute("mensajeOk", "Tu inscripción se registró correctamente.");
        }

        return "redirect:/actividades/trabajador/lista";
    }

    @GetMapping("/trabajador/mis-actividades")
    public String verMisActividades(Model model, HttpSession session, RedirectAttributes redirect) {

        UsuarioDTO usuarioDTO = (UsuarioDTO) session.getAttribute("usuarioActual");
        if (usuarioDTO == null) {
            return "redirect:/auth/login";
        }

        if (!"T".equalsIgnoreCase(usuarioDTO.getTipoUsuario())) {
            redirect.addFlashAttribute("mensajeError", "Solo los trabajadores pueden ver sus inscripciones.");
            return "redirect:/actividades/lista";
        }

        Usuario usuario = usuarioIRep.findById(usuarioDTO.getIdUsuario())
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));

        var inscripciones = inscripcionIRep.findByUsuario(usuario);

        model.addAttribute("usuario", usuarioDTO);
        model.addAttribute("inscripciones", inscripciones);

        return "actividades/misActividadesTrabajador";
    }


    // RH
    @GetMapping("/rh/lista")
    public String listarActividadesRH(Model model, HttpSession session) {
        UsuarioDTO usuario = (UsuarioDTO) session.getAttribute("usuarioActual");
        if (usuario == null) return "redirect:/auth/login";
        if (!"R".equalsIgnoreCase(usuario.getTipoUsuario())) {
            return "redirect:/actividades/lista";
        }
        model.addAttribute("usuario", usuario);
        model.addAttribute("actividades", actividadIRep.findAll());
        return "actividades/listaActividadesRH";
    }

    // EQUIPO OPERATIVO
    @GetMapping("/equipo/lista")
    public String listarActividadesEquipo(Model model, HttpSession session) {
        UsuarioDTO usuario = (UsuarioDTO) session.getAttribute("usuarioActual");
        if (usuario == null) return "redirect:/auth/login";
        if (!"E".equalsIgnoreCase(usuario.getTipoUsuario())) {
            return "redirect:/actividades/lista";
        }
        model.addAttribute("usuario", usuario);
        model.addAttribute("actividades", actividadIRep.findAll());
        return "actividades/listaActividadesEquipo";
    }
}
