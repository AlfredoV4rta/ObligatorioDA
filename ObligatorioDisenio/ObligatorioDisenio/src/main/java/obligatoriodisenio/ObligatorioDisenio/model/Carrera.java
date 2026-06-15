package obligatoriodisenio.ObligatorioDisenio.model;

import java.util.ArrayList;
import java.util.List;

import obligatoriodisenio.ObligatorioDisenio.observador.Observable;

public class Carrera extends Observable {
    private List<Participacion> participaciones;
    private Jornada jornada;
    private Estado estado;
    private int nroCarrera;
    private String nombre;
    private Participacion participacionGanadora;

    public Carrera() {
        this.participaciones = new ArrayList<>();
    }

    public Carrera(int nroCarrera, String nombre, Jornada jornada) {
        this();
        this.nroCarrera = nroCarrera;
        this.nombre = nombre;
        this.jornada = jornada;
        this.estado = Estado.DEFINIDA;
        this.participacionGanadora = null;
    }

    public List<Participacion> getParticipaciones() {
        return participaciones;
    }

    public Jornada getJornada() {
        return jornada;
    }

    public Estado getEstado() {
        return estado;
    }

    public int getNroCarrera() {
        return nroCarrera;
    }

    public String getNombre() {
        return nombre;
    }

    public Participacion getParticipacion() {
        return participacionGanadora;
    }


    public void agregarParticipacion(Participacion participacion) {
        this.participaciones.add(participacion);
    }

    public void removerParticipacion(Participacion participacion) {
        this.participaciones.remove(participacion);
    }

    public boolean estaDisponible() {
        return this.estado == Estado.ABIERTA || this.estado == Estado.ESTABLE;
    }
}
