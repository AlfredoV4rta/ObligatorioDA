package obligatoriodisenio.ObligatorioDisenio.model;

import java.util.ArrayList;
import java.util.List;

import obligatoriodisenio.ObligatorioDisenio.observador.Observable;

public class Carrera extends Observable {
    private List<Participacion> participaciones;
    private Jornada jornada;
    private EstadoCarrera estado;
    private int nroCarrera;
    private String nombre;
    private Participacion participacionGanadora;

    public Carrera() {
        this.participaciones = new ArrayList<>();
        this.estado = new Definida();
    }

    public Carrera(int nroCarrera, String nombre, Jornada jornada) {
        this();
        this.nroCarrera = nroCarrera;
        this.nombre = nombre;
        this.jornada = jornada;
        this.participacionGanadora = null;
    }

    public List<Participacion> getParticipaciones() {
        return participaciones;
    }

    public Jornada getJornada() {
        return jornada;
    }

    public EstadoCarrera getEstado() {
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

    public void cambiarEstado(EstadoCarrera nuevoEstado) {
        this.estado = nuevoEstado;
    }

    public void asignarGanador(Participacion ganador) {
        this.participacionGanadora = ganador;
    }

    public void abrir() throws MalaPataException {
        estado.abrir(this);
    }

    public void cerrar() throws MalaPataException {
        estado.cerrar(this);
    }

    public void finalizar(Participacion ganador) throws MalaPataException {
        estado.finalizar(this, ganador);
    }

    public void actualizarEstabilidad() {
        estado.actualizarEstabilidad(this);
    }

    public boolean estaDisponible() {
        return estado.puedeApostar();
    }

    public boolean todosDividendosValidos() {
        for (Participacion p : participaciones) {
            if (!p.dividendoValido()) {
                return false;
            }
        }
        return true;
    }

    public double totalApostado() {
        double total = 0;
        for (Participacion p : participaciones) {
            total += p.totalApostado();
        }
        return total;
    }

    public void recalcularDividendos(double comision) {
        double montoARepartir = totalApostado() * (1 - comision);
        for (Participacion p : participaciones) {
            p.actualizarDividendo(montoARepartir);
        }
    }
}
