package com.example.voluntariado_p2sem.jpa.model;

import jakarta.persistence.*;

@Entity
@Table(name = "equipo_operativo")
public class EquipoOperativo {

    @Id
    @Column(name = "id_equipooper")
    private Integer idEquipoOper;

    @Column(name = "arearesponsableeqoper", length = 50)
    private String areaResponsableEqOper;

    @Column(name = "inventarioasignadoeqoper", length = 50)
    private String inventarioAsignadoEqOper;

    @Column(name = "telefonocontacto", length = 20)
    private String telefonoContacto;

    public Integer getIdEquipoOper() { return idEquipoOper; }
    public void setIdEquipoOper(Integer idEquipoOper) { this.idEquipoOper = idEquipoOper; }

    public String getAreaResponsableEqOper() { return areaResponsableEqOper; }
    public void setAreaResponsableEqOper(String areaResponsableEqOper) {
        this.areaResponsableEqOper = areaResponsableEqOper;
    }

    public String getInventarioAsignadoEqOper() { return inventarioAsignadoEqOper; }
    public void setInventarioAsignadoEqOper(String inventarioAsignadoEqOper) {
        this.inventarioAsignadoEqOper = inventarioAsignadoEqOper;
    }

    public String getTelefonoContacto() { return telefonoContacto; }
    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }
}
