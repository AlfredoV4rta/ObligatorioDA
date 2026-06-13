package obligatoriodisenio.ObligatorioDisenio.DTOs;

import java.util.ArrayList;
import java.util.List;

import obligatoriodisenio.ObligatorioDisenio.model.Participacion;

/**
 * Caballo participante de una carrera, tal como lo muestra el tablero del jugador:
 * número, nombre y dividendo actual (o "S/E" si no es válido).
 */
public class ParticipacionDTO {
    private int numero;
    private String nombreCaballo;
    private String dividendo;

    public ParticipacionDTO(Participacion participacion) {
        this.numero = participacion.getNroParticipacion();
        this.nombreCaballo = participacion.getCaballo().getNombre();
        // TODO (bocado #4): el dividendo debe ser dinámico y por participación, y la
        // validez = (apuestas al caballo > 0 && dividendo > 1). Por ahora se lee del
        // caballo y solo se chequea > 1.
        double div = participacion.getCaballo().getDividendo();
        this.dividendo = (div > 1) ? String.format("%.2f", div) : "S/E";
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
