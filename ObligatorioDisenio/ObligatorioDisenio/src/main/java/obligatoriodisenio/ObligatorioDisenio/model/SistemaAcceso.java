package obligatoriodisenio.ObligatorioDisenio.model;

import java.util.ArrayList;
import java.util.List;

public class SistemaAcceso {
    private List<Usuario> jugadores;
    private List<Usuario> administradores;

    public SistemaAcceso() {
        this.jugadores = new ArrayList<>();
        this.administradores = new ArrayList<>();
    }

    public List<Usuario> getJugadores() {
        return jugadores;
    }

    public List<Usuario> getAdministradores() {
        return administradores;
    }

    public void agregarJugador(Usuario usuario) {
        this.jugadores.add(usuario);
    }

    public void removerJugador(Usuario usuario) {
        this.jugadores.remove(usuario);
    }

    public Usuario buscarJugador(String nombreUsuario, String contrasenia) {
        Usuario jugadorBuscado = new Jugador(nombreUsuario, contrasenia, null, null, 0);
        if (jugadores.contains(jugadorBuscado)) {
            return jugadores.get(jugadores.indexOf(jugadorBuscado));
        }
        return null;
    }

    public void agregarAdministradores(Usuario usuario) {
        this.administradores.add(usuario);
    }

    public void removerAdministrador(Usuario usuario) {
        this.administradores.remove(usuario);
    }

    public Usuario buscarAdministrador(String nombreUsuario, String contrasenia) {
        Usuario administradorBuscado = new Administrador(nombreUsuario, contrasenia, null, null);
        if (administradores.contains(administradorBuscado)) {
            return administradores.get(administradores.indexOf(administradorBuscado));
        }
        return null;
    }
}
