package obligatoriodisenio.ObligatorioDisenio.model;

public class Resultado {
    private Participacion participacionGanadora;

    public Resultado() {
    }

    public Resultado(Participacion participacionGanadora) {
        this.participacionGanadora = participacionGanadora;
    }

    public Participacion getParticipacionGanadora() {
        return participacionGanadora;
    }

    public void setParticipacionGanadora(Participacion participacionGanadora) {
        this.participacionGanadora = participacionGanadora;
    }
}
