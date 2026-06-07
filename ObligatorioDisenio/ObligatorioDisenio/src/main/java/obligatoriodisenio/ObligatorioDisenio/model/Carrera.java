package obligatoriodisenio.ObligatorioDisenio.model;

import java.util.ArrayList;
import java.util.List;

public class Carrera implements Observable {
    private List<Participacion> participaciones;
    private Jornada jornada;
    private Estado estado;
    private int nroCarrera;
    private String nombre;
    private Participacion participacionGanadora;
    private List<Observer> observers;

    public Carrera() {
        this.participaciones = new ArrayList<>();
        this.observers = new ArrayList<>();
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

    @Override
    public void agregarObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removerObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notificarObservers() {
        for (Observer o : observers) {
            o.actualizar();
        }
    }

    public boolean estaDisponible() {
        return this.estado == Estado.DEFINIDA;
    }
}
