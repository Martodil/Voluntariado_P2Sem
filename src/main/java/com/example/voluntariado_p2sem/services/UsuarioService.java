package com.example.voluntariado_p2sem.services;

import com.example.voluntariado_p2sem.dto.UsuarioDTO;
import com.example.voluntariado_p2sem.dto.UsuarioRegistroDTO;
import com.example.voluntariado_p2sem.fbo.LoginFrm;
import com.example.voluntariado_p2sem.fbo.RegistroUsuarioFrm;
import com.example.voluntariado_p2sem.jpa.model.Usuario;
import com.example.voluntariado_p2sem.jpa.repositories.UsuarioIRep;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioIRep usuarioIRep;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    // ========= REGISTRO DE USUARIO =========

    public UsuarioRegistroDTO registrarNuevoUsuario(RegistroUsuarioFrm frm) {

        // 1. Validaciones básicas de negocio
        if (!frm.getPassword().equals(frm.getConfirmarPassword())) {
            throw new IllegalArgumentException("Las contraseñas no coinciden");
        }

        if (usuarioIRep.existsByEmailUsuarioIgnoreCase(frm.getEmailUsuario())) {
            throw new IllegalArgumentException("El correo electrónico ya está registrado");
        }

        if (usuarioIRep.existsByNombreUsuario(frm.getNombreUsuario())) {
            throw new IllegalArgumentException("El nombre de usuario ya está en uso");
        }

        // Validar tipo de usuario permitido (Trabajador, Administrador, Recursos humanos o Equipo operativo)
        String tipo = frm.getTipoUsuario();
        if (!(tipo.equals("T") || tipo.equals("A") || tipo.equals("R") || tipo.equals("E"))) {
            throw new IllegalArgumentException("Tipo de usuario no válido");
        }

        // 2. Convertir idEmpleado a Integer (puede lanzar NumberFormatException si está mal)
        Integer idEmpleado = null;
        if (frm.getIdEmpleado() != null && !frm.getIdEmpleado().isBlank()) {
            idEmpleado = Integer.parseInt(frm.getIdEmpleado());
        }

        // 3. Crear entidad Usuario y asignar valores
        Usuario usuario = new Usuario();
        usuario.setIdEmpleado(idEmpleado);
        usuario.setNombreUsuario(frm.getNombreUsuario());
        usuario.setEmailUsuario(frm.getEmailUsuario());

        // emailConfirmado siempre true (no manejamos correo real)
        usuario.setEmailConfirmado(true);

        // 4. Encriptar contraseña con BCrypt
        String hash = passwordEncoder.encode(frm.getPassword());
        usuario.setContraUsuario(hash);

        usuario.setTipoUsuario(tipo);

        // 5. Guardar en base de datos
        Usuario usuarioGuardado = usuarioIRep.save(usuario);

        // 6. Mapear a DTO de registro
        UsuarioRegistroDTO dto = new UsuarioRegistroDTO();
        dto.setIdUsuario(usuarioGuardado.getIdUsuario());
        dto.setNombreUsuario(usuarioGuardado.getNombreUsuario());
        dto.setEmailUsuario(usuarioGuardado.getEmailUsuario());
        dto.setTipoUsuario(usuarioGuardado.getTipoUsuario());

        return dto;
    }

    // ========= LOGIN DE USUARIO =========

    public UsuarioDTO validarLogin(LoginFrm frm) {

        String input = frm.getUsuario();

        // 1. Buscar por email (case-insensitive)
        Optional<Usuario> opt = usuarioIRep.findByEmailUsuarioIgnoreCase(input);

        // 2. Si no lo encuentra por email, buscar por nombre de usuario
        if (opt.isEmpty()) {
            opt = usuarioIRep.findByNombreUsuario(input);
        }

        if (opt.isEmpty()) {
            // Usuario no existe
            return null;
        }

        Usuario usuario = opt.get();

        // 3. Verificar que el correo esté confirmado (aunque siempre será true)
        if (Boolean.FALSE.equals(usuario.getEmailConfirmado())) {
            return null;
        }

        // 4. Verificar contraseña con BCrypt
        boolean okPassword = passwordEncoder.matches(frm.getPassword(), usuario.getContraUsuario());
        if (!okPassword) {
            return null;
        }

        // 5. Mapear a UsuarioDTO (lo que guardamos en sesión)
        UsuarioDTO dto = new UsuarioDTO();
        dto.setIdUsuario(usuario.getIdUsuario());
        dto.setNombreUsuario(usuario.getNombreUsuario());
        dto.setEmailUsuario(usuario.getEmailUsuario());
        dto.setTipoUsuario(usuario.getTipoUsuario());

        return dto;
    }
}
