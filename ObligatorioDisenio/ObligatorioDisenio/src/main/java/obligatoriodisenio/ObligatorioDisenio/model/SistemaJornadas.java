package obligatoriodisenio.ObligatorioDisenio.model;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class SistemaJornadas {
    private List<Jornada> jornadas;

    public SistemaJornadas() {
        this.jornadas = new ArrayList<>();
    }

    public List<Jornada> getJornadas() {
        return jornadas;
    }

    public void agregarJornada(Jornada jornada) {
        this.jornadas.add(jornada);
    }

    public void removerJornada(Jornada jornada) {
        this.jornadas.remove(jornada);
    }

    public void agregarCarreraAJornada(Jornada jornada, Carrera carrera) {
        jornada.agregarCarrera(carrera);
    }

    public void removerCarreraDeJornada(Jornada jornada, Carrera carrera) {
        jornada.removerCarrera(carrera);
    }

    public void agregarCarreraAJornada(LocalDate fechaJornada, Carrera carrera) {
        Jornada jornada = buscarJornadaPorFecha(fechaJornada);
        if (jornada != null) {
            jornada.agregarCarrera(carrera);
        }
    }

    private Jornada buscarJornadaPorFecha(LocalDate fechaJornada) {
        for (Jornada j : jornadas) {
            if (j.getFecha() != null && j.getFecha().equals(fechaJornada)) {
                return j;
            }
        }
        return null;
    }

    public List<Carrera> obtenerCarrerasDisponibles() {
        List<Carrera> carrerasDisponibles = new ArrayList<>();
        for (Jornada j : jornadas) {
            List<Carrera> carrerasDisponiblesDeJornada = j.carrerasDisponibles();
            if (!carrerasDisponiblesDeJornada.isEmpty()) {
                carrerasDisponibles.addAll(carrerasDisponiblesDeJornada);
            }
        }
        return carrerasDisponibles;
    }
}
