package com.example.voluntariado_p2sem.jpa.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "sede")
public class Sede implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sede")
    private Integer idSede;

    @Column(name = "id_municipio")
    private Integer idMunicipio;

    @Column(name = "nombresede", length = 150)
    private String nombreSede;

    @Column(name = "direccionsede", length = 255)
    private String direccionSede;

    // Getters y setters

    public Integer getIdSede() {
        return idSede;
    }

    public void setIdSede(Integer idSede) {
        this.idSede = idSede;
    }

    public Integer getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(Integer idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public String getNombreSede() {
        return nombreSede;
    }

    public void setNombreSede(String nombreSede) {
        this.nombreSede = nombreSede;
    }

    public String getDireccionSede() {
        return direccionSede;
    }

    public void setDireccionSede(String direccionSede) {
        this.direccionSede = direccionSede;
    }
}
