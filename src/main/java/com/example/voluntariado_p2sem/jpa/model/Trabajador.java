package com.example.voluntariado_p2sem.jpa.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "trabajador")
public class Trabajador implements Serializable {

    @Id
    @Column(name = "id_trabajador")
    private Integer idTrabajador;

    // === Campos extra según tu tabla ===
    @Column(name = "deptotrab", length = 50)
    private String deptotrab;

    @Column(name = "puestotrab", length = 50)
    private String puestoTrab;

    @Column (name ="horasacumuladastrab")
    private int horasacumuladastrab;

    public Integer getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(Integer idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public int getHorasacumuladastrab() {
        return horasacumuladastrab;
    }

    public void setHorasacumuladastrab(int horasacumuladastrab) {
        this.horasacumuladastrab = horasacumuladastrab;
    }

    public String getPuestoTrab() {
        return puestoTrab;
    }

    public void setPuestoTrab(String puestoTrab) {
        this.puestoTrab = puestoTrab;
    }

    public String getDeptotrab() {
        return deptotrab;
    }

    public void setDeptotrab(String deptotrab) {
        this.deptotrab = deptotrab;
    }
}
