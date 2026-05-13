package obligatoriodisenio.ObligatorioDisenio.model;

public class Apuesta {
    private Participacion participacion;
    private Modalidad modalidad;

    public Apuesta() {
    }

    public Apuesta(Participacion participacion, Modalidad modalidad) {
        this.participacion = participacion;
        this.modalidad = modalidad;
    }

    public Participacion getParticipacion() {
        return participacion;
    }

    public Modalidad getModalidad() {
        return modalidad;
    }

    public void setModalidad(Modalidad modalidad) {
        this.modalidad = modalidad;
    }
}
