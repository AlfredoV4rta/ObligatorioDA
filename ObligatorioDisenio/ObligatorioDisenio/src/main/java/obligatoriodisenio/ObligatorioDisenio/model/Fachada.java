package obligatoriodisenio.ObligatorioDisenio.model;

import obligatoriodisenio.ObligatorioDisenio.model.Modalidad;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

public class Fachada {
    private static Fachada instancia;
    private SistemaJornadas sistemaJornadas;
    private SistemaAcceso sistemaAcceso;
    private SistemaApuestas sistemaApuestas;

    public Fachada() {
        this.sistemaJornadas = new SistemaJornadas();
        this.sistemaAcceso = new SistemaAcceso();
    }

    public static Fachada getInstance() {
        if (instancia == null) {
            instancia = new Fachada();
        }
        return instancia;
    }

    public SistemaJornadas getSistemaJornadas() {
        return sistemaJornadas;
    }

    public SistemaAcceso getSistemaAcceso() {
        return sistemaAcceso;
    }

    public SistemaApuestas getSistemaApuestas() {
        return sistemaApuestas;
    }

    // Métodos de negocio
    // ACCESO
    public Usuario login(String nombreUsuario, String contrasenia) {
        return sistemaAcceso.buscarJugador(nombreUsuario, contrasenia);
    }

    public void registrarJugador(Jugador usuario) {
        sistemaAcceso.agregarJugador(usuario);
    }

    public void registrarAdministrador(Administrador administrador) {
        sistemaAcceso.agregarAdministrador(administrador);
    }

    public Jugador buscarJugador(String nombreUsuario, String contrasenia) {
        return sistemaAcceso.buscarJugador(nombreUsuario, contrasenia);
    }

    public Administrador buscarAdministrador(String nombreUsuario, String contrasenia) {
        return sistemaAcceso.buscarAdministrador(nombreUsuario, contrasenia);
    }

    public Jugador obtenerInfoJugador(String nombreUsuario) {
        return sistemaAcceso.obtenerInfoJugador(nombreUsuario);
    }

    // JORNADA
    public void crearJornada(Jornada jornada) {
        sistemaJornadas.agregarJornada(jornada);
    }

    public void agregarCarreraAJornada(Jornada jornada, Carrera carrera) {
        jornada.agregarCarrera(carrera);
    }

    public List<Carrera> obtenerCarrerasDisponibles() {
        return sistemaJornadas.obtenerCarrerasDisponibles();
    }

    // APUESTAS
    public void crearApuesta(Usuario usuario, Apuesta apuesta) {
        usuario.agregarApuesta(apuesta);
    }

    public List<Modalidad> obtenerTiposApuesta() {
        List<Modalidad> modalidades = new ArrayList<>();
        modalidades.add(new Simple());
        modalidades.add(new Triple());
        modalidades.add(new Super());
        return modalidades;
    }

    public List<Apuesta> obtenerApuestasUsuario(String nombreUsuario) {
        Jugador jugador = sistemaAcceso.obtenerInfoJugador(nombreUsuario);
        if (jugador != null) {
            return jugador.getApuestas();
        }
        return new ArrayList<>();
    }



}
