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

    public double totalApostado() {
        double total = 0;
        for (Carrera c : carreras) {
            total += c.totalApostado();
        }
        return total;
    }

    public double totalPagado() {
        double total = 0;
        for (Carrera c : carreras) {
            total += c.totalPagado();
        }
        return total;
    }

    public int cantidadFinalizadas() {
        int cant = 0;
        for (Carrera c : carreras) {
            if (c.estaFinalizada()) {
                cant++;
            }
        }
        return cant;
    }

    public List<Carrera> carrerasFinalizadas() {
        List<Carrera> result = new ArrayList<>();
        for (Carrera c : carreras) {
            if (c.estaFinalizada()) {
                result.add(c);
            }
        }
        return result;
    }

    public List<Carrera> carrerasProximas() {
        List<Carrera> result = new ArrayList<>();
        for (Carrera c : carreras) {
            if (!c.estaFinalizada()) {
                result.add(c);
            }
        }
        return result;
    }
}
