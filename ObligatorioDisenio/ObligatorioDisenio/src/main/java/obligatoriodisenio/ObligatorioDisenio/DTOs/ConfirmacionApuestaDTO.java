package obligatoriodisenio.ObligatorioDisenio.DTOs;

import obligatoriodisenio.ObligatorioDisenio.model.Carrera;
import obligatoriodisenio.ObligatorioDisenio.model.Modalidad;
import obligatoriodisenio.ObligatorioDisenio.model.Participacion;

public class ConfirmacionApuestaDTO {
    private int nroCarrera;
    private String nombreCarrera;
    private int nroCaballo;
    private String nombreCaballo;
    private String dividendoActual;
    private double monto;
    private String tipoApuesta;
    private double montoADebitar;
    private double cobrariaSiGana;

    public ConfirmacionApuestaDTO(Participacion participacion, Modalidad modalidad, double monto) {
        Carrera carrera = participacion.getCarrera();
        this.nroCarrera = carrera.getNroCarrera();
        this.nombreCarrera = carrera.getNombre();
        this.nroCaballo = participacion.getNroParticipacion();
        this.nombreCaballo = participacion.getCaballo().getNombre();
        this.dividendoActual = participacion.dividendoValido()
                ? String.format("%.2f", participacion.getDividendo())
                : "S/E";
        this.monto = monto;
        this.tipoApuesta = modalidad.getNombre();
        this.montoADebitar = modalidad.calcularCosto(monto);
        this.cobrariaSiGana = modalidad.calcularPago(monto, participacion.getDividendo(), participacion.totalApostado());
    }

    public int getNroCarrera() {
        return nroCarrera;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public int getNroCaballo() {
        return nroCaballo;
    }

    public String getNombreCaballo() {
        return nombreCaballo;
    }

    public String getDividendoActual() {
        return dividendoActual;
    }

    public double getMonto() {
        return monto;
    }

    public String getTipoApuesta() {
        return tipoApuesta;
    }

    public double getMontoADebitar() {
        return montoADebitar;
    }

    public double getCobrariaSiGana() {
        return cobrariaSiGana;
    }
}
