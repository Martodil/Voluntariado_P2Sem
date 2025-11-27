package com.example.voluntariado_p2sem.dto;

public class UsuarioDTO {

    private Integer idUsuario;
    private String nombreUsuario;
    private String emailUsuario;
    private String tipoUsuario;

    // ===== Getters y setters =====

    public Integer getIdUsuario() { return idUsuario; }
    public void setIdUsuario(Integer idUsuario) { this.idUsuario = idUsuario; }

    public String getNombreUsuario() { return nombreUsuario; }
    public void setNombreUsuario(String nombreUsuario) { this.nombreUsuario = nombreUsuario; }

    public String getEmailUsuario() { return emailUsuario; }
    public void setEmailUsuario(String emailUsuario) { this.emailUsuario = emailUsuario; }

    public String getTipoUsuario() { return tipoUsuario; }
    public void setTipoUsuario(String tipoUsuario) { this.tipoUsuario = tipoUsuario; }

    public String getTipoUsuarioDescripcion() {
        if (tipoUsuario == null) { return ""; }
        switch (tipoUsuario) {
            case "A":
                return "ADMINISTRADOR";
            case "R":
                return " PERSONAL DE RECURSOS HUMANOS";
            case "T":
                return "TRABAJADOR";
            case "E":
                return "PERSONAL DE EQUIPO OPERATIVO";
            default:
                return "DESCONOCIDO";
        }
    }
}
