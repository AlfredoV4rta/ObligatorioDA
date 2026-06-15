package obligatoriodisenio.ObligatorioDisenio.DTOs;

import java.util.ArrayList;
import java.util.List;

import obligatoriodisenio.ObligatorioDisenio.model.Carrera;

public class CarreraDTO {
    private int numero;
    private String fecha;
    private List<ParticipacionDTO> caballos;

    public CarreraDTO(Carrera carrera) {
        this.numero = carrera.getNroCarrera();
        this.fecha = (carrera.getJornada() != null && carrera.getJornada().getFecha() != null)
                ? carrera.getJornada().getFecha().toString()
                : "";
        this.caballos = ParticipacionDTO.fromList(carrera.getParticipaciones());
    }

    public int getNumero() {
        return numero;
    }

    public String getFecha() {
        return fecha;
    }

    public List<ParticipacionDTO> getCaballos() {
        return caballos;
    }

    public static List<CarreraDTO> fromList(List<Carrera> carreras) {
        List<CarreraDTO> result = new ArrayList<>();
        for (Carrera c : carreras) {
            result.add(new CarreraDTO(c));
        }
        return result;
    }
}
