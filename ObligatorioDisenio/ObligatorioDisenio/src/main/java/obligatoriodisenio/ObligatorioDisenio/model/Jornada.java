package obligatoriodisenio.ObligatorioDisenio.model;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class Jornada {
    private List<Carrera> carreras;
    private LocalDate fecha;

    public Jornada() {
        this.carreras = new ArrayList<>();
        this.fecha = LocalDate.now(); // fecha actual
    }

    public Jornada(LocalDate fecha) {
        this.carreras = new ArrayList<>();
        this.fecha = fecha; // fecha específica
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public List<Carrera> getCarreras() {
        return carreras;
    }

    public void agregarCarrera(Carrera carrera) {
        this.carreras.add(carrera);
    }

    public void removerCarrera(Carrera carrera) {
        this.carreras.remove(carrera);
    }

    public List<Carrera> carrerasDisponibles() {
        List<Carrera> carrerasDisponibles = new ArrayList<>();
        for (Carrera c : carreras) {
            if (c.estaDisponible()) {
                carrerasDisponibles.add(c);
            }
        }
        return carrerasDisponibles;
    }                                                                                                       
}
