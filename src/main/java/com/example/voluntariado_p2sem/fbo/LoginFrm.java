package com.example.voluntariado_p2sem.fbo;

import jakarta.validation.constraints.NotBlank;

public class LoginFrm {

    @NotBlank(message = "Debe ingresar un usuario o correo electrónico")
    private String usuario;

    @NotBlank(message = "Debe ingresar la contraseña")
    private String password;

    // ===== Getters y setters =====

    public String getUsuario() { return usuario; }
    public void setUsuario(String usuario) { this.usuario = usuario; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
