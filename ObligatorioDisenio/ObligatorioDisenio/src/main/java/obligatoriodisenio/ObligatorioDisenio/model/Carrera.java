package obligatoriodisenio.ObligatorioDisenio.model;

import java.util.ArrayList;
import java.util.List;

public class Carrera {
    private List<Participacion> participaciones;
    private Jornada jornada;
    private Estado estado;
    private int nroCarrera;
    private String nombre;
    private Resultado resultado;

    public Carrera() {
        this.participaciones = new ArrayList<>();
    }

    public Carrera(int nroCarrera, String nombre, Jornada jornada) {
        this();
        this.nroCarrera = nroCarrera;
        this.nombre = nombre;
        this.jornada = jornada;
        this.estado = Estado.PENDIENTE;
    }

    public List<Participacion> getParticipaciones() {
        return participaciones;
    }

    public void setParticipaciones(List<Participacion> participaciones) {
        this.participaciones = participaciones;
    }

    public Jornada getJornada() {
        return jornada;
    }

    public void setJornada(Jornada jornada) {
        this.jornada = jornada;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public int getNroCarrera() {
        return nroCarrera;
    }

    public void setNroCarrera(int nroCarrera) {
        this.nroCarrera = nroCarrera;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Resultado getResultado() {
        return resultado;
    }

    public void setResultado(Resultado resultado) {
        this.resultado = resultado;
    }

    public void agregarParticipacion(Participacion participacion) {
        this.participaciones.add(participacion);
    }

    public void removerParticipacion(Participacion participacion) {
        this.participaciones.remove(participacion);
    }
}
