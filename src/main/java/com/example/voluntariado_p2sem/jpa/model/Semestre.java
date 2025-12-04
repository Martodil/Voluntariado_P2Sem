package com.example.voluntariado_p2sem.jpa.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "semestre")
public class Semestre implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_semestre")
    private Integer idSemestre;

    @Column(name = "nosemestre")
    private Integer noSemestre;

    @Column(name = "aniosemestre")
    private Integer anioSemestre;

    // Getters y setters

    public Integer getIdSemestre() {
        return idSemestre;
    }

    public void setIdSemestre(Integer idSemestre) {
        this.idSemestre = idSemestre;
    }

    public Integer getNoSemestre() {
        return noSemestre;
    }

    public void setNoSemestre(Integer noSemestre) {
        this.noSemestre = noSemestre;
    }

    public Integer getAnioSemestre() {
        return anioSemestre;
    }

    public void setAnioSemestre(Integer anioSemestre) {
        this.anioSemestre = anioSemestre;
    }
}