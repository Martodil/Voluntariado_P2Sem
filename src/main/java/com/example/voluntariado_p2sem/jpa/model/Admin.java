package com.example.voluntariado_p2sem.jpa.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "admin")
public class Admin {

    @Id
    @Column(name = "id_admin")
    private Integer idAdmin;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "ultimaconexionadmin")
    private LocalDate ultimaConexionAdmin;

    @Column(name = "permisosespecialesadmin", length = 50)
    private String permisosEspecialesAdmin;

    public Integer getIdAdmin() { return idAdmin; }
    public void setIdAdmin(Integer idAdmin) { this.idAdmin = idAdmin; }

    public LocalDate getUltimaConexionAdmin() { return ultimaConexionAdmin; }
    public void setUltimaConexionAdmin(LocalDate ultimaConexionAdmin) {
        this.ultimaConexionAdmin = ultimaConexionAdmin;
    }

    public String getPermisosEspecialesAdmin() { return permisosEspecialesAdmin; }
    public void setPermisosEspecialesAdmin(String permisosEspecialesAdmin) {
        this.permisosEspecialesAdmin = permisosEspecialesAdmin;
    }
}
