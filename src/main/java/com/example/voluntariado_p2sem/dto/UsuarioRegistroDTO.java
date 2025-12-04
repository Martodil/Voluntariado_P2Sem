package com.example.voluntariado_p2sem.dto;

public class UsuarioRegistroDTO {

    private Integer idUsuario;
    private String nombreUsuario;
    private String emailUsuario;
    private String tipoUsuario;

    //Datos específicos para el trabajador
    private String puestotrab;
    private String deptotrab;
    private int horasacumuladastrab;
    // ===== Getters y setters =====

    public Integer getIdUsuario() { return idUsuario; }
    public void setIdUsuario(Integer idUsuario) { this.idUsuario = idUsuario; }

    public String getNombreUsuario() { return nombreUsuario; }
    public void setNombreUsuario(String nombreUsuario) { this.nombreUsuario = nombreUsuario; }

    public String getEmailUsuario() { return emailUsuario; }
    public void setEmailUsuario(String emailUsuario) { this.emailUsuario = emailUsuario; }

    public String getTipoUsuario() { return tipoUsuario; }
    public void setTipoUsuario(String tipoUsuario) { this.tipoUsuario = tipoUsuario; }


    public int getHorasacumuladastrab() { return horasacumuladastrab; }
    public void setHorasacumuladastrab(int horasacumuladastrab) { this.horasacumuladastrab = horasacumuladastrab; }

    public String getDeptotrab() { return deptotrab; }
    public void setDeptotrab(String deptotrab) { this.deptotrab = deptotrab; }

    public String getPuestotrab() { return puestotrab; }
    public void setPuestotrab(String puestotrab) { this.puestotrab = puestotrab; }
}
