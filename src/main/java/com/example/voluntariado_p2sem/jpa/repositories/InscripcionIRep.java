package com.example.voluntariado_p2sem.jpa.repositories;

import com.example.voluntariado_p2sem.jpa.model.Actividad;
import com.example.voluntariado_p2sem.jpa.model.Inscripcion;
import com.example.voluntariado_p2sem.jpa.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InscripcionIRep extends JpaRepository<Inscripcion, Integer> {

    boolean existsByUsuarioAndActividad(Usuario usuario, Actividad actividad);

    List<Inscripcion> findByUsuario(Usuario usuario);
}
