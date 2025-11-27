package com.example.voluntariado_p2sem.jpa.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer idUsuario;

    // NOTA: en la BD es INTEGER, aquí lo mapeamos como Integer
    @Column(name = "id_empleado")
    private Integer idEmpleado;

    @Column(name = "nombreusuario", nullable = false, length = 15)
    private String nombreUsuario;

    // En la BD es CITEXT (case-insensitive). Lo mapeamos como String.
    @Column(name = "emailusuario", nullable = false, unique = true)
    private String emailUsuario;

    // Contraseña encriptada con BCrypt (hash completo)
    @Column(name = "contrausuario", nullable = false)
    private String contraUsuario;

    // Valores esperados: 'T', 'A', 'R', 'E'
    @Column(name = "tipousuario", nullable = false, length = 5)
    private String tipoUsuario;

    @Column(name = "emailconfirmado")
    private Boolean emailConfirmado;

    // ===== CONSTRUCTORES =====

    public Usuario() {
    }

    // Contructor de conveniencia
    public Usuario(Integer idEmpleado,
                   String nombreUsuario,
                   String emailUsuario,
                   String contraUsuario,
                   String tipoUsuario,
                   Boolean emailConfirmado) {
        this.idEmpleado = idEmpleado;
        this.nombreUsuario = nombreUsuario;
        this.emailUsuario = emailUsuario;
        this.contraUsuario = contraUsuario;
        this.tipoUsuario = tipoUsuario;
        this.emailConfirmado = emailConfirmado;
    }

    // ===== GETTERS y SETTERS =====

    public Integer getIdUsuario() { return idUsuario; }
    public void setIdUsuario(Integer idUsuario) { this.idUsuario = idUsuario; }

    public Integer getIdEmpleado() { return idEmpleado; }
    public void setIdEmpleado(Integer idEmpleado) { this.idEmpleado = idEmpleado; }

    public String getNombreUsuario() { return nombreUsuario; }
    public void setNombreUsuario(String nombreUsuario) { this.nombreUsuario = nombreUsuario; }

    public String getEmailUsuario() { return emailUsuario; }
    public void setEmailUsuario(String emailUsuario) { this.emailUsuario = emailUsuario; }

    public String getContraUsuario() { return contraUsuario; }
    public void setContraUsuario(String contraUsuario) { this.contraUsuario = contraUsuario; }

    public String getTipoUsuario() { return tipoUsuario; }
    public void setTipoUsuario(String tipoUsuario) { this.tipoUsuario = tipoUsuario; }

    public Boolean getEmailConfirmado() { return emailConfirmado; }
    public void setEmailConfirmado(Boolean emailConfirmado) { this.emailConfirmado = emailConfirmado; }

    // ===== equals, hashCode y toString =====

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario)) return false;
        Usuario other = (Usuario) o;
        return idUsuario != null && idUsuario.equals(other.getIdUsuario());
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + idUsuario +
                ", nombreUsuario='" + nombreUsuario + '\'' +
                ", emailUsuario='" + emailUsuario + '\'' +
                ", tipoUsuario='" + tipoUsuario + '\'' +
                ", emailConfirmado=" + emailConfirmado +
                '}';
    }
}