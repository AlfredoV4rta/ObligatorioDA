package obligatoriodisenio.ObligatorioDisenio.model;

import java.util.ArrayList;
import java.util.List;

public class SistemaJugadores {
    private List<Usuario> usuario;

    public SistemaJugadores() {
        this.usuario = new ArrayList<>();
    }

    public List<Usuario> getUsuario() {
        return usuario;
    }

    public void setUsuario(List<Usuario> usuario) {
        this.usuario = usuario;
    }

    public void agregarUsuario(Usuario usuario) {
        this.usuario.add(usuario);
    }

    public void removerUsuario(Usuario usuario) {
        this.usuario.remove(usuario);
    }
}
