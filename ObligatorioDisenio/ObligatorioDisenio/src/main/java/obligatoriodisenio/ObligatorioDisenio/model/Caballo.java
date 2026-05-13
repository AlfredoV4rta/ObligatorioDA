package obligatoriodisenio.ObligatorioDisenio.model;

import java.util.ArrayList;
import java.util.List;

public class Caballo {
    private String nombre;
    private double dividendo;
    private List<Participacion> participaciones;

    public Caballo() {
        this.participaciones = new ArrayList<>();
    }

    public Caballo(String nombre, double dividendo) {
        this();
        this.nombre = nombre;
        this.dividendo = dividendo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getDividendo() {
        return dividendo;
    }

    public List<Participacion> getParticipaciones() {
        return participaciones;
    }

    public void setParticipaciones(List<Participacion> participaciones) {
        this.participaciones = participaciones;
    }

    public void agregarParticipacion(Participacion participacion) {
        this.participaciones.add(participacion);
    }

    public void removerParticipacion(Participacion participacion) {
        this.participaciones.remove(participacion);
    }
}
