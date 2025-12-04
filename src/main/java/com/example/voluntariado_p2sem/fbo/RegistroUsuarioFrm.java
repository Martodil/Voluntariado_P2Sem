package com.example.voluntariado_p2sem.fbo;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class RegistroUsuarioFrm {


    @NotBlank(message = "El id de empleado es obligatorio")
    private String idEmpleado;

    @NotBlank(message = "El nombre de usuario es obligatorio")
    @Size(max = 15, message = "El nombre de usuario no debe exceder 15 caracteres")
    private String nombreUsuario;

    @NotBlank(message = "El correo electrónico es obligatorio")
    @Email(message = "El correo electrónico no tiene un formato válido")
    private String emailUsuario;

    @NotBlank(message = "La contraseña es obligatoria")
    @Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres")
    private String password;

    @NotBlank(message = "Debe confirmar la contraseña")
    private String confirmarPassword;

    @NotBlank(message = "Debe seleccionar un tipo de usuario")
    private String tipoUsuario;

    // Atributos exclusivos del trabajador
    private String puestoTrab;
    private String deptotrab;
    private int horasacumuladastrab;

    //Atributos exclusivos de recursos humanos
    private String areaResponsableRh;

    //Atributos exclusivos para equipo operativo
    private String areaResponsableEqOper;
    private String inventarioAsignadoEqOper;
    private String telefonoContactoEqOper;

    //Atributo para el administrador
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate ultimaRevisionRh;

    // ===== Getters y setters =====

    public String getIdEmpleado() { return idEmpleado; }
    public void setIdEmpleado(String idEmpleado) { this.idEmpleado = idEmpleado; }

    public String getNombreUsuario() { return nombreUsuario; }
    public void setNombreUsuario(String nombreUsuario) { this.nombreUsuario = nombreUsuario; }

    public String getEmailUsuario() { return emailUsuario; }
    public void setEmailUsuario(String emailUsuario) { this.emailUsuario = emailUsuario; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getConfirmarPassword() { return confirmarPassword; }
    public void setConfirmarPassword(String confirmarPassword) { this.confirmarPassword = confirmarPassword; }

    public String getTipoUsuario() { return tipoUsuario; }
    public void setTipoUsuario(String tipoUsuario) { this.tipoUsuario = tipoUsuario; }

    public int getHorasacumuladastrab() { return horasacumuladastrab; }
    public void setHorasacumuladastrab(int horasacumuladastrab) { this.horasacumuladastrab = horasacumuladastrab; }

    public String getDeptotrab() { return deptotrab; }
    public void setDeptotrab(String deptotrab) { this.deptotrab = deptotrab; }

    public String getPuestoTrab() { return puestoTrab; }
    public void setPuestoTrab(String puestoTrab) { this.puestoTrab = puestoTrab; }

    public String getAreaResponsableRh() { return areaResponsableRh; }
    public void setAreaResponsableRh(String areaResponsableRh) { this.areaResponsableRh = areaResponsableRh; }

    public LocalDate getUltimaRevisionRh() { return ultimaRevisionRh; }
    public void setUltimaRevisionRh(LocalDate ultimaRevisionRh) { this.ultimaRevisionRh = ultimaRevisionRh; }

    public String getTelefonoContactoEqOper() { return telefonoContactoEqOper; }
    public void setTelefonoContactoEqOper(String telefonoContactoEqOper) { this.telefonoContactoEqOper = telefonoContactoEqOper; }

    public String getAreaResponsableEqOper() { return areaResponsableEqOper; }
    public void setAreaResponsableEqOper(String areaResponsableEqOper) { this.areaResponsableEqOper = areaResponsableEqOper; }

    public String getInventarioAsignadoEqOper() { return inventarioAsignadoEqOper; }
    public void setInventarioAsignadoEqOper(String inventarioAsignadoEqOper) { this.inventarioAsignadoEqOper = inventarioAsignadoEqOper; }
}
