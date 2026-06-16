package obligatoriodisenio.ObligatorioDisenio.model;

import java.time.LocalDate;

public class Apuesta {
    private Participacion participacion;
    private Modalidad modalidad;
    private double monto;
    private LocalDate fecha;
    private double montoCobrado;
    private double dividendoFinal;

    public Apuesta() {
    }

    public Apuesta(Participacion participacion, Modalidad modalidad, double monto) {
        this.participacion = participacion;
        this.modalidad = modalidad;
        this.monto = monto;
        this.fecha = LocalDate.now();
        this.montoCobrado = 0;
        this.dividendoFinal = 0;
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

    public LocalDate getFecha() {
        return fecha;
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
