package obligatoriodisenio.ObligatorioDisenio.model;

public class Participacion {
    private Caballo caballo;
    private Carrera carrera;

    public Participacion() {
    }

    public Participacion(Caballo caballo, Carrera carrera) {
        this.caballo = caballo;
        this.carrera = carrera;
    }

    public Caballo getCaballo() {
        return caballo;
    }

    public Carrera getCarrera() {
        return carrera;
    }

}
