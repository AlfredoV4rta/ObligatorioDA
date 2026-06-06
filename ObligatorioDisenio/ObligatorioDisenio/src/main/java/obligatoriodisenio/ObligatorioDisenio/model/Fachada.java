package obligatoriodisenio.ObligatorioDisenio.model;

import org.springframework.stereotype.Component;

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
    public void crearJornada(Jornada jornada) {
        sistemaJornadas.agregarJornada(jornada);
    }

    public void agregarCarreraAJornada(Jornada jornada, Carrera carrera) {
        jornada.agregarCarrera(carrera);
    }

    public void registrarJugador(Jugador usuario) {
        sistemaAcceso.agregarJugador(usuario);
    }

    public void registrarAdministrador(Administrador administrador) {
        sistemaAcceso.agregarAdministrador(administrador);
    }

    public void crearApuesta(Usuario usuario, Apuesta apuesta) {
        usuario.agregarApuesta(apuesta);
    }

    public Usuario login(String nombreUsuario, String contrasenia) {
        return sistemaAcceso.buscarJugador(nombreUsuario, contrasenia);
    }

  
}
