package obligatoriodisenio.ObligatorioDisenio.model;

import org.springframework.stereotype.Component;

public class Fachada {
    private static Fachada instancia;
    private SistemaJornadas sistemaJornadas;
    private SistemaAcceso sistemaAcceso;

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

    public void setSistemaJornadas(SistemaJornadas sistemaJornadas) {
        this.sistemaJornadas = sistemaJornadas;
    }

    // Métodos de negocio
    public void crearJornada(Jornada jornada) {
        sistemaJornadas.agregarJornada(jornada);
    }

    public void agregarCarreraAJornada(Jornada jornada, Carrera carrera) {
        jornada.agregarCarrera(carrera);
    }

    public void registrarJugadores(Jugador jugador) {
        sistemaAcceso.agregarJugador(jugador);
    }

    public void registrarAdministrador(Administrador administrador) {
        sistemaAcceso.agregarAdministradores(administrador);
    }

    public void crearApuesta(Usuario usuario, Apuesta apuesta) {
       // usuario.agregarApuesta(apuesta);
    }

    /*public Usuario login(String nombreUsuario, String contrasenia) {
        return sistemaJugadores.buscarUsuario(nombreUsuario, contrasenia);
    }*/

  
}
