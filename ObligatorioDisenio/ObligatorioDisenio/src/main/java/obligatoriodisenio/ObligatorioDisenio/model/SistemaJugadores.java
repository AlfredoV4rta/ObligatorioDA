package obligatoriodisenio.ObligatorioDisenio.model;

import java.util.ArrayList;
import java.util.List;

public class SistemaJugadores {
    private List<Usuario> usuarios;

    public SistemaJugadores() {
        this.usuarios = new ArrayList<>();
    }

    public List<Usuario> getUsuario() {
        return usuarios;
    }

    public void agregarUsuario(Usuario usuario) {
        this.usuarios.add(usuario);
    }

    public void removerUsuario(Usuario usuario) {
        this.usuarios.remove(usuario);
    }

    public Usuario buscarUsuario(String nombreUsuario, String contrasenia) {
        Usuario usuarioBuscado = new Usuario(nombreUsuario, contrasenia, null, null);
        if (usuarios.contains(usuarioBuscado)) {
            return usuarios.get(usuarios.indexOf(usuarioBuscado));
        }
        return null;
    }
}
