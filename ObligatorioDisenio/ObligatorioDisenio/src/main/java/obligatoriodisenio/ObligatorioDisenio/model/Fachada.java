package obligatoriodisenio.ObligatorioDisenio.model;

import org.springframework.stereotype.Component;

public class Fachada {
    private static Fachada instancia;
    private SistemaJornadas sistemaJornadas;
    private SistemaUsuarios sistemaUsuarios;

    public Fachada() {
        this.sistemaJornadas = new SistemaJornadas();
        this.sistemaUsuarios = new SistemaUsuarios();
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


    public SistemaUsuarios getSistemaUsuarios() {
        return sistemaUsuarios;
    }

    // Métodos de negocio
    public void crearJornada(Jornada jornada) {
        sistemaJornadas.agregarJornada(jornada);
    }

    public void agregarCarreraAJornada(Jornada jornada, Carrera carrera) {
        jornada.agregarCarrera(carrera);
    }

    public void registrarUsuario(Usuario usuario) {
        sistemaUsuarios.agregarUsuario(usuario);
    }

    public void registrarAdministrador(Administrador administrador) {
        sistemaUsuarios.agregarUsuario(administrador);
    }

    public void crearApuesta(Usuario usuario, Apuesta apuesta) {
        usuario.agregarApuesta(apuesta);
    }

    public Usuario login(String nombreUsuario, String contrasenia) {
        return sistemaUsuarios.buscarUsuario(nombreUsuario, contrasenia);
    }

  
}
