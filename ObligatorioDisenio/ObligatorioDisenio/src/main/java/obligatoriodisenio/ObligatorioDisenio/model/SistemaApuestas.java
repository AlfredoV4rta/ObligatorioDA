package obligatoriodisenio.ObligatorioDisenio.model;

import java.util.ArrayList;
import java.util.List;

public class SistemaApuestas {
    private List<Apuesta> apuestas;

    public SistemaApuestas() {
        this.apuestas = new ArrayList<>();
    }

    public void agregarApuesta(Apuesta apuesta) {
        apuestas.add(apuesta);
    }

    public List<Apuesta> getApuestas() {
        return apuestas;
    }
}
