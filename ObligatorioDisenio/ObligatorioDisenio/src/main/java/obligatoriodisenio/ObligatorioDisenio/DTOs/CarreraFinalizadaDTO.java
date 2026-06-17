package obligatoriodisenio.ObligatorioDisenio.DTOs;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import obligatoriodisenio.ObligatorioDisenio.model.Carrera;
import obligatoriodisenio.ObligatorioDisenio.model.Participacion;

public class CarreraFinalizadaDTO {
    private int numero;
    private String nombre;
    private String horaFinalizacion;
    private int cantidadCaballos;
    private double totalApostado;
    private double totalPagado;
    private String caballoGanador;
    private String dividendoFinal;

    public CarreraFinalizadaDTO(Carrera carrera) {
        this.numero = carrera.getNroCarrera();
        this.nombre = carrera.getNombre();
        this.horaFinalizacion = carrera.getHoraFinalizacion() != null
                ? carrera.getHoraFinalizacion().format(DateTimeFormatter.ofPattern("HH:mm"))
                : "-";
        this.cantidadCaballos = carrera.getParticipaciones().size();
        this.totalApostado = carrera.totalApostado();
        this.totalPagado = carrera.totalPagado();
        Participacion ganador = carrera.getParticipacion();
        if (ganador != null) {
            this.caballoGanador = ganador.getCaballo().getNombre();
            this.dividendoFinal = String.format("%.2f", ganador.getDividendo());
        } else {
            this.caballoGanador = "-";
            this.dividendoFinal = "-";
        }
    }

    public int getNumero() {
        return numero;
    }

    public String getNombre() {
        return nombre;
    }

    public String getHoraFinalizacion() {
        return horaFinalizacion;
    }

    public int getCantidadCaballos() {
        return cantidadCaballos;
    }

    public double getTotalApostado() {
        return totalApostado;
    }

    public double getTotalPagado() {
        return totalPagado;
    }

    public String getCaballoGanador() {
        return caballoGanador;
    }

    public String getDividendoFinal() {
        return dividendoFinal;
    }

    public static List<CarreraFinalizadaDTO> fromList(List<Carrera> carreras) {
        List<CarreraFinalizadaDTO> result = new ArrayList<>();
        for (Carrera c : carreras) {
            result.add(new CarreraFinalizadaDTO(c));
        }
        return result;
    }
}
