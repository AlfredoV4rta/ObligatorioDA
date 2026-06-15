package obligatoriodisenio.ObligatorioDisenio.DTOs;

import obligatoriodisenio.ObligatorioDisenio.model.Jugador;

public class JugadorDTO {
    private String nombreUsuario;
    private String nombreCompleto;
    private double saldo;
    private double montoTotalApostado;
    private double montoTotalGanado;

    public JugadorDTO(Jugador jugador) {
        this.nombreUsuario = jugador.getNombreUsuario();
        this.nombreCompleto = jugador.getNombreCompleto();
        this.saldo = jugador.getSaldo();
        this.montoTotalApostado = jugador.getMontoTotalApostado();
        this.montoTotalGanado = jugador.getMontoTotalGanado();
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getMontoTotalApostado() {
        return montoTotalApostado;
    }

    public double getMontoTotalGanado() {
        return montoTotalGanado;
    }
}
