package obligatoriodisenio.ObligatorioDisenio.DTOs;

import java.util.ArrayList;
import java.util.List;

import obligatoriodisenio.ObligatorioDisenio.model.Apuesta;
import obligatoriodisenio.ObligatorioDisenio.model.Participacion;

public class ApuestaDTO {
    private int nroCarrera;
    private String nombreCarrera;
    private int nroCaballo;
    private String nombreCaballo;
    private double montoApostado;
    private String tipoApuesta;
    private double montoCobrado;
    private double dividendoFinal;
    private String estatus;

    public ApuestaDTO(Apuesta apuesta) {
        Participacion p = apuesta.getParticipacion();
        this.nroCarrera = p.getCarrera().getNroCarrera();
        this.nombreCarrera = p.getCarrera().getNombre();
        this.nroCaballo = p.getNroParticipacion();
        this.nombreCaballo = p.getCaballo().getNombre();
        this.montoApostado = apuesta.getMonto();
        this.tipoApuesta = apuesta.getModalidad().getNombre();
        this.montoCobrado = 0;
        this.dividendoFinal = 0;
        this.estatus = "Por correr";
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

    public double getMontoApostado() {
        return montoApostado;
    }

    public String getTipoApuesta() {
        return tipoApuesta;
    }

    public double getMontoCobrado() {
        return montoCobrado;
    }

    public double getDividendoFinal() {
        return dividendoFinal;
    }

    public String getEstatus() {
        return estatus;
    }

    public static List<ApuestaDTO> fromList(List<Apuesta> apuestas) {
        List<ApuestaDTO> result = new ArrayList<>();
        for (Apuesta a : apuestas) {
            result.add(new ApuestaDTO(a));
        }
        return result;
    }
}
