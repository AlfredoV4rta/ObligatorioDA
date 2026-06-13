package obligatoriodisenio.ObligatorioDisenio.model;

public class Apuesta {
    private Participacion participacion;
    private Modalidad modalidad;
    private double monto;

    public Apuesta() {
    }

    public Apuesta(Participacion participacion, Modalidad modalidad, double monto) {
        this.participacion = participacion;
        this.modalidad = modalidad;
        this.monto = monto;
    }

    public Participacion getParticipacion() {
        return participacion;
    }

    public Modalidad getModalidad() {
        return modalidad;
    }

    public double getMonto() {
        return monto;
    }

}
