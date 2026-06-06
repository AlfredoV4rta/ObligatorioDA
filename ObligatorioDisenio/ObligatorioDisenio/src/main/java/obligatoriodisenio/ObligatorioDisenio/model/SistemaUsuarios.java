package obligatoriodisenio.ObligatorioDisenio.model;

import java.util.ArrayList;
import java.util.List;

public class SistemaUsuarios {
    private List<Usuario> usuarios;

    public SistemaUsuarios() {
        this.usuarios = new ArrayList<>();
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void agregarUsuario(Usuario usuario) {
        this.usuarios.add(usuario);
    }

    public void removerUsuario(Usuario usuario) {
        this.usuarios.remove(usuario);
    }

    public Usuario buscarUsuario(String nombreUsuario, String contrasenia) {
        for (Usuario u : usuarios) {
            if (u.getNombreUsuario() != null && u.getContrasenia() != null &&
                u.getNombreUsuario().equals(nombreUsuario) && u.getContrasenia().equals(contrasenia)) {
                if (u instanceof Administrador) {
                    return (Administrador) u;
                }
                return u;
            }
        }
        return null;
    }
}
