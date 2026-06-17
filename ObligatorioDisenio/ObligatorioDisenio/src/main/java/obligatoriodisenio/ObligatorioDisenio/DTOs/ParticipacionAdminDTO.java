package obligatoriodisenio.ObligatorioDisenio.DTOs;

import java.util.ArrayList;
import java.util.List;

import obligatoriodisenio.ObligatorioDisenio.model.Participacion;

public class ParticipacionAdminDTO {
    private int numero;
    private String nombreCaballo;
    private String dividendo;
    private double totalApostado;
    private int cantidadApuestas;

    public ParticipacionAdminDTO(Participacion participacion) {
        this.numero = participacion.getNroParticipacion();
        this.nombreCaballo = participacion.getCaballo().getNombre();
        this.dividendo = participacion.dividendoValido()
                ? String.format("%.2f", participacion.getDividendo())
                : "S/E";
        this.totalApostado = participacion.totalApostado();
        this.cantidadApuestas = participacion.cantidadApuestas();
    }

    public int getNumero() {
        return numero;
    }

    public String getNombreCaballo() {
        return nombreCaballo;
    }

    public String getDividendo() {
        return dividendo;
    }

    public double getTotalApostado() {
        return totalApostado;
    }

    public int getCantidadApuestas() {
        return cantidadApuestas;
    }

    public static List<ParticipacionAdminDTO> fromList(List<Participacion> participaciones) {
        List<ParticipacionAdminDTO> result = new ArrayList<>();
        for (Participacion p : participaciones) {
            result.add(new ParticipacionAdminDTO(p));
        }
        return result;
    }
}
