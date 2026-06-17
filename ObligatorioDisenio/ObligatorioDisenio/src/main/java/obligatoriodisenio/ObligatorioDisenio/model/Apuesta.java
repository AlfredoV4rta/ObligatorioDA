package obligatoriodisenio.ObligatorioDisenio.model;

public class Apuesta {
    private Jugador jugador;
    private Participacion participacion;
    private Modalidad modalidad;
    private double monto;
    private double montoCobrado;
    private double dividendoFinal;

    public Apuesta() {
    }

    public Apuesta(Jugador jugador, Participacion participacion, Modalidad modalidad, double monto) {
        this.jugador = jugador;
        this.participacion = participacion;
        this.modalidad = modalidad;
        this.monto = monto;
        this.montoCobrado = 0;
        this.dividendoFinal = 0;
    }

    public Jugador getJugador() {
        return jugador;
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

    public double getMontoCobrado() {
        return montoCobrado;
    }

    public double getDividendoFinal() {
        return dividendoFinal;
    }

    public void liquidar(double montoCobrado, double dividendoFinal) {
        this.montoCobrado = montoCobrado;
        this.dividendoFinal = dividendoFinal;
    }
}
