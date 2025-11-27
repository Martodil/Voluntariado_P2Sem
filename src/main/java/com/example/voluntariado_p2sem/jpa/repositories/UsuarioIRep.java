package com.example.voluntariado_p2sem.jpa.repositories;

import com.example.voluntariado_p2sem.jpa.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UsuarioIRep extends JpaRepository<Usuario, Integer> {

    // Buscar por email sin importar mayúsculas/minúsculas
    Optional<Usuario> findByEmailUsuarioIgnoreCase(String emailUsuario);

    // Buscar por nombre de usuario
    Optional<Usuario> findByNombreUsuario(String nombreUsuario);

    // Verificar si ya existe un usuario con ese email
    boolean existsByEmailUsuarioIgnoreCase(String emailUsuario);

    // Verificar si ya existe un usuario con ese nombre
    boolean existsByNombreUsuario(String nombreUsuario);
}
