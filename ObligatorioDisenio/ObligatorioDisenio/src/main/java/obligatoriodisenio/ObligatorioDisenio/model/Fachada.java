package obligatoriodisenio.ObligatorioDisenio.model;

import org.springframework.stereotype.Component;

@Component
public class Fachada {
    private SistemaJornadas sistemaJornadas;
    private SistemaJugadores sistemaJugadores;
    private SistemaAdministradores sistemaAdministradores;

    public Fachada() {
        this.sistemaJornadas = new SistemaJornadas();
        this.sistemaJugadores = new SistemaJugadores();
        this.sistemaAdministradores = new SistemaAdministradores();
    }

    public SistemaJornadas getSistemaJornadas() {
        return sistemaJornadas;
    }

    public void setSistemaJornadas(SistemaJornadas sistemaJornadas) {
        this.sistemaJornadas = sistemaJornadas;
    }

    public SistemaJugadores getSistemaJugadores() {
        return sistemaJugadores;
    }

    public SistemaAdministradores getSistemaAdministradores() {
        return sistemaAdministradores;
    }

    // Métodos de negocio
    public void crearJornada(Jornada jornada) {
        sistemaJornadas.agregarJornada(jornada);
    }

    public void agregarCarreraAJornada(Jornada jornada, Carrera carrera) {
        jornada.agregarCarrera(carrera);
    }

    public void registrarUsuario(Usuario usuario) {
        sistemaJugadores.agregarUsuario(usuario);
    }

    public void registrarAdministrador(Administrador administrador) {
        sistemaAdministradores.agregarUsuario(administrador);
    }

    public void crearApuesta(Usuario usuario, Apuesta apuesta) {
        usuario.agregarApuesta(apuesta);
    }

    public Usuario login(String nombreUsuario, String contrasenia) {
        return sistemaJugadores.buscarUsuario(nombreUsuario, contrasenia);
    }
}
