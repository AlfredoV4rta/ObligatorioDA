package obligatoriodisenio.ObligatorioDisenio.model;

import java.util.ArrayList;
import java.util.List;

public class Jornada {
    private List<Carrera> carreras;

    public Jornada() {
        this.carreras = new ArrayList<>();
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
