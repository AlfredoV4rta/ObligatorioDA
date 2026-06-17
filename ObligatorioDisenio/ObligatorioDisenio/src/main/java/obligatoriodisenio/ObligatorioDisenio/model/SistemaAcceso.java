package obligatoriodisenio.ObligatorioDisenio.model;

import java.util.ArrayList;
import java.util.List;

public class SistemaAcceso {
    private List<Jugador> jugadores;
    private List<Administrador> administradores;
    private List<Administrador> adminsConectados;

    public SistemaAcceso() {
        this.jugadores = new ArrayList<>();
        this.administradores = new ArrayList<>();
        this.adminsConectados = new ArrayList<>();
    }

    public List<Administrador> getAdministradores() {
        return administradores;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    // METODOS JUGADOR
    public void agregarJugador(Jugador jugador) {
        this.jugadores.add(jugador);
    }

    public void removerJugador(Jugador jugador) {
        this.jugadores.remove(jugador);
    }

    public Jugador buscarJugador(String nombreJugador, String contrasenia) {
        for (Jugador j : jugadores) {
            if (j.getNombreUsuario() != null && j.getContrasenia() != null &&
                j.getNombreUsuario().equals(nombreJugador) && j.getContrasenia().equals(contrasenia)) {
                return j;
            }
        }
        return null;
    }

    public Jugador obtenerInfoJugador(String nombreUsuario) {
        for (Jugador j : jugadores) {
            if (j.getNombreUsuario() != null && j.getNombreUsuario().equals(nombreUsuario)) {
                return j;
            }
        }
        return null;
    }

    // METODOS ADMINISTRADOR
    public void agregarAdministrador(Administrador administrador) {
        this.administradores.add(administrador);
    }

    public void removerAdministrador(Administrador administrador) {
        this.administradores.remove(administrador);
    }

    public Administrador buscarAdministrador(String nombreAdministrador, String contrasenia) {
        for (Administrador a : administradores) {
            if (a.getNombreUsuario() != null && a.getContrasenia() != null &&
                a.getNombreUsuario().equals(nombreAdministrador) && a.getContrasenia().equals(contrasenia)) {
                return a;
            }
        }
        return null;
    }

    public void iniciarSesionAdmin(Administrador administrador) throws MalaPataException {
        if (adminsConectados.contains(administrador)) {
            throw new MalaPataException("Este administrador ya tiene una sesión abierta");
        }
        adminsConectados.add(administrador);
    }

    public void cerrarSesionAdmin(Administrador administrador) {
        adminsConectados.remove(administrador);
    }
}
