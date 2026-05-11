package obligatoriodisenio.ObligatorioDisenio.model;

import java.util.ArrayList;
import java.util.List;

public class SistemaJornadas {
    private List<Jornada> jornadas;

    public SistemaJornadas() {
        this.jornadas = new ArrayList<>();
    }

    public List<Jornada> getJornadas() {
        return jornadas;
    }

    public void setJornadas(List<Jornada> jornadas) {
        this.jornadas = jornadas;
    }

    public void agregarJornada(Jornada jornada) {
        this.jornadas.add(jornada);
    }

    public void removerJornada(Jornada jornada) {
        this.jornadas.remove(jornada);
    }
}
