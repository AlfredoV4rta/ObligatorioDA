package obligatoriodisenio.ObligatorioDisenio.DTOs;

import java.util.ArrayList;
import java.util.List;

import obligatoriodisenio.ObligatorioDisenio.model.Modalidad;

public class ModalidadDTO {
    private String nombre;

    public ModalidadDTO(Modalidad modalidad) {
        this.nombre = modalidad.getNombre();
    }

    public String getNombre() {
        return nombre;
    }

    public static List<ModalidadDTO> fromList(List<Modalidad> modalidades) {
        List<ModalidadDTO> result = new ArrayList<>();
        for (Modalidad m : modalidades) {
            result.add(new ModalidadDTO(m));
        }
        return result;
    }
}
