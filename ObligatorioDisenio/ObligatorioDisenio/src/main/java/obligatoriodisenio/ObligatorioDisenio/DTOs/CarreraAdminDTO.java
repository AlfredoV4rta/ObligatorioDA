package obligatoriodisenio.ObligatorioDisenio.DTOs;

import java.util.ArrayList;
import java.util.List;

import obligatoriodisenio.ObligatorioDisenio.model.Carrera;

public class CarreraAdminDTO {
    private int numero;
    private String nombre;
    private String estado;
    private int cantidadCaballos;
    private double totalApostado;
    private int cantidadApuestas;
    private List<ParticipacionAdminDTO> caballos;

    public CarreraAdminDTO(Carrera carrera) {
        this.numero = carrera.getNroCarrera();
        this.nombre = carrera.getNombre();
        this.estado = carrera.getEstado().getNombre();
        this.cantidadCaballos = carrera.getParticipaciones().size();
        this.totalApostado = carrera.totalApostado();
        this.cantidadApuestas = carrera.cantidadApuestas();
        this.caballos = ParticipacionAdminDTO.fromList(carrera.getParticipaciones());
    }

    public int getNumero() {
        return numero;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEstado() {
        return estado;
    }

    public int getCantidadCaballos() {
        return cantidadCaballos;
    }

    public double getTotalApostado() {
        return totalApostado;
    }

    public int getCantidadApuestas() {
        return cantidadApuestas;
    }

    public List<ParticipacionAdminDTO> getCaballos() {
        return caballos;
    }

    public static List<CarreraAdminDTO> fromList(List<Carrera> carreras) {
        List<CarreraAdminDTO> result = new ArrayList<>();
        for (Carrera c : carreras) {
            result.add(new CarreraAdminDTO(c));
        }
        return result;
    }
}
