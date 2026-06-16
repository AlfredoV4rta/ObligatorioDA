package obligatoriodisenio.ObligatorioDisenio.DTOs;

import java.util.ArrayList;
import java.util.List;

import obligatoriodisenio.ObligatorioDisenio.model.Participacion;

public class ParticipacionDTO {
    private int numero;
    private String nombreCaballo;
    private String dividendo;

    public ParticipacionDTO(Participacion participacion) {
        this.numero = participacion.getNroParticipacion();
        this.nombreCaballo = participacion.getCaballo().getNombre();
        this.dividendo = participacion.dividendoValido()
                ? String.format("%.2f", participacion.getDividendo())
                : "S/E";
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

    public static List<ParticipacionDTO> fromList(List<Participacion> participaciones) {
        List<ParticipacionDTO> result = new ArrayList<>();
        for (Participacion p : participaciones) {
            result.add(new ParticipacionDTO(p));
        }
        return result;
    }
}
