package obligatoriodisenio.ObligatorioDisenio.model;

import obligatoriodisenio.ObligatorioDisenio.observador.Observable;

import java.util.List;
import java.util.ArrayList;

public class Fachada extends Observable {
    private static Fachada instancia;
    private SistemaJornadas sistemaJornadas;
    private SistemaAcceso sistemaAcceso;
    private SistemaApuestas sistemaApuestas;
    public enum Eventos {
        CARRERA_ACTUALIZADA,
        APUESTA_ACTUALIZADA
    }

    private Fachada() {
        this.sistemaJornadas = new SistemaJornadas();
        this.sistemaAcceso = new SistemaAcceso();
        this.sistemaApuestas = new SistemaApuestas();
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

    // ACCESO
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

    public Jornada getJornadaActual() {
        return sistemaJornadas.getJornadaActual();
    }

    public Jornada jornadaSiguiente(Jornada jornada) {
        return sistemaJornadas.jornadaSiguiente(jornada);
    }

    public Jornada jornadaAnterior(Jornada jornada) {
        return sistemaJornadas.jornadaAnterior(jornada);
    }

    public double getComision() {
        return sistemaApuestas.getComision();
    }

    public void abrirCarrera(Carrera carrera) throws MalaPataException {
        carrera.abrir();
        avisar(Eventos.CARRERA_ACTUALIZADA);
    }

    public void cerrarCarrera(Carrera carrera) throws MalaPataException {
        carrera.cerrar();
        avisar(Eventos.CARRERA_ACTUALIZADA);
    }

    public void finalizarCarrera(Carrera carrera, Participacion ganador) throws MalaPataException {
        carrera.finalizar(ganador);
        carrera.liquidar();
        avisar(Eventos.CARRERA_ACTUALIZADA);
    }

    // APUESTAS
    public void registrarApuesta(Jugador jugador, Participacion participacion, Modalidad modalidad,
            double monto, String password) throws MalaPataException {
        sistemaApuestas.registrarApuesta(jugador, participacion, modalidad, monto, password);
        avisar(Eventos.APUESTA_ACTUALIZADA);
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
