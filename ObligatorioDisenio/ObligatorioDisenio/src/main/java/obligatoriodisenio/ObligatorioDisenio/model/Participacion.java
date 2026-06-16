package obligatoriodisenio.ObligatorioDisenio.model;

import java.util.ArrayList;
import java.util.List;

public class Participacion {
    private int nroParticipacion;
    private Caballo caballo;
    private Carrera carrera;
    private List<Apuesta> apuestas = new ArrayList<>();
    private double dividendo;

    public Participacion() {
    }

    public Participacion(int nroParticipacion, Caballo caballo, Carrera carrera) {
        this.nroParticipacion = nroParticipacion;
        this.caballo = caballo;
        this.carrera = carrera;
    }

    public int getNroParticipacion() {
        return nroParticipacion;
    }

    public Caballo getCaballo() {
        return caballo;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void agregarApuesta(Apuesta apuesta) {
        this.apuestas.add(apuesta);
    }

    public double totalApostado() {
        double total = 0;
        for (Apuesta a : apuestas) {
            total += a.getMonto();
        }
        return total;
    }

    public int cantidadApuestas() {
        return apuestas.size();
    }

    public double getDividendo() {
        return dividendo;
    }

    public void actualizarDividendo(double montoARepartir) {
        double total = totalApostado();
        if (total > 0) {
            this.dividendo = montoARepartir / total;
        } else {
            this.dividendo = 0;
        }
    }

    public boolean dividendoValido() {
        return cantidadApuestas() > 0 && dividendo > 1;
    }
}
