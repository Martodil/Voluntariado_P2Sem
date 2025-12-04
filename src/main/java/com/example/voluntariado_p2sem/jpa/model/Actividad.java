package com.example.voluntariado_p2sem.jpa.model;
//comentario
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "actividad")
public class Actividad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_actividad")
    private Integer idActividad;

    @Column(name = "id_sede", nullable = false)
    private Integer idSede;

    @Column(name = "id_semestre", nullable = false)
    private Integer idSemestre;

    @Column(name = "claveturnoact", nullable = false)
    private Integer claveTurnoAct;

    @Column(name = "tituloact", nullable = false, length = 150)
    private String tituloAct;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "fechaact", nullable = false)
    private LocalDate fechaAct;

    @Column(name = "horarioact", length = 60)
    private String horarioAct;

    @Column(name = "responsableact", length = 150)
    private String responsableAct;

    @Column(name = "cupoact")
    private Integer cupoAct;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "vigenciaact")
    private LocalDate vigenciaAct;

    public Integer getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(Integer idActividad) {
        this.idActividad = idActividad;
    }

    public Integer getIdSede() {
        return idSede;
    }

    public void setIdSede(Integer idSede) {
        this.idSede = idSede;
    }

    public Integer getIdSemestre() {
        return idSemestre;
    }

    public void setIdSemestre(Integer idSemestre) {
        this.idSemestre = idSemestre;
    }

    public Integer getClaveTurnoAct() {
        return claveTurnoAct;
    }

    public void setClaveTurnoAct(Integer claveTurnoAct) {
        this.claveTurnoAct = claveTurnoAct;
    }

    public String getTituloAct() {
        return tituloAct;
    }

    public void setTituloAct(String tituloAct) {
        this.tituloAct = tituloAct;
    }

    public LocalDate getFechaAct() {
        return fechaAct;
    }

    public void setFechaAct(LocalDate fechaAct) {
        this.fechaAct = fechaAct;
    }

    public String getHorarioAct() {
        return horarioAct;
    }

    public void setHorarioAct(String horarioAct) {
        this.horarioAct = horarioAct;
    }

    public String getResponsableAct() {
        return responsableAct;
    }

    public void setResponsableAct(String responsableAct) {
        this.responsableAct = responsableAct;
    }

    public Integer getCupoAct() {
        return cupoAct;
    }

    public void setCupoAct(Integer cupoAct) {
        this.cupoAct = cupoAct;
    }

    public LocalDate getVigenciaAct() {
        return vigenciaAct;
    }

    public void setVigenciaAct(LocalDate vigenciaAct) {
        this.vigenciaAct = vigenciaAct;
    }

}
