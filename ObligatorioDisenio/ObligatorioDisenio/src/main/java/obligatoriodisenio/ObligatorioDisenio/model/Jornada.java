package obligatoriodisenio.ObligatorioDisenio.model;

import java.util.ArrayList;
import java.util.List;

import java.time.LocalDate;

public class Jornada {
    private LocalDate fecha;
    private List<Carrera> carreras;

    public Jornada() {
        this.carreras = new ArrayList<>();
    }

    public Jornada(LocalDate fecha) {
        this.fecha = fecha;
        this.carreras = new ArrayList<>();
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
}
