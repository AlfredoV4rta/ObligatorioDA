package obligatoriodisenio.ObligatorioDisenio.model;

import java.util.ArrayList;
import java.util.List;

public class Caballo {
    private String nombre;
    private List<Participacion> participaciones;

    public Caballo() {
        this.participaciones = new ArrayList<>();
    }

    public Caballo(String nombre) {
        this();
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Participacion> getParticipaciones() {
        return participaciones;
    }

    public void agregarParticipacion(Participacion participacion) {
        this.participaciones.add(participacion);
    }

    public void removerParticipacion(Participacion participacion) {
        this.participaciones.remove(participacion);
    }
}
