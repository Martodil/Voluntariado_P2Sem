package com.example.voluntariado_p2sem.jpa.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "recursos_humanos")
public class RecursosHumanos {

    @Id
    @Column(name = "id_recursoshum")
    private Integer idRecursosHum;

    @Column(name = "reportesgeneradosrh")
    private Integer reportesGeneradosRh;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "ultimarevisionrh")
    private LocalDate ultimaRevisionRh;

    @Column(name = "arearesponsablerh", length = 50)
    private String areaResponsableRh;

    public Integer getIdRecursosHum() { return idRecursosHum; }
    public void setIdRecursosHum(Integer idRecursosHum) { this.idRecursosHum = idRecursosHum; }

    public Integer getReportesGeneradosRh() { return reportesGeneradosRh; }
    public void setReportesGeneradosRh(Integer reportesGeneradosRh) {
        this.reportesGeneradosRh = reportesGeneradosRh;
    }

    public LocalDate getUltimaRevisionRh() { return ultimaRevisionRh; }
    public void setUltimaRevisionRh(LocalDate ultimaRevisionRh) {
        this.ultimaRevisionRh = ultimaRevisionRh;
    }

    public String getAreaResponsableRh() { return areaResponsableRh; }
    public void setAreaResponsableRh(String areaResponsableRh) {
        this.areaResponsableRh = areaResponsableRh;
    }
}
