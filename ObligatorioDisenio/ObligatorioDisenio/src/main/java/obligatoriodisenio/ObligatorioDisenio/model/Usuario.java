package obligatoriodisenio.ObligatorioDisenio.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Usuario {
    private String nombreUsuario;
    private String contrasenia;
    private String nombre;
    private String apellido;

    public Usuario() {
    }

    public Usuario(String nombreUsuario, String contrasenia, String nombre, String apellido) {
        this();
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.nombre = nombre;
        this.apellido = apellido;
    }


    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Usuario usuario = (Usuario) obj;
        return Objects.equals(nombreUsuario, usuario.nombreUsuario) &&
               Objects.equals(contrasenia, usuario.contrasenia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombreUsuario, contrasenia);
    }
}
