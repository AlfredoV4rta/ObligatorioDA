package obligatoriodisenio.ObligatorioDisenio.model;

public class Participacion {
    private int nroParticipacion;
    private Caballo caballo;
    private Carrera carrera;

    public Participacion() {
    }

    public Participacion(int nroParticipacion, Caballo caballo, Carrera carrera) {
        this.nroParticipacion = nroParticipacion;
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
