package obligatoriodisenio.ObligatorioDisenio.DTOs;

import obligatoriodisenio.ObligatorioDisenio.model.Jugador;

public class JugadorDTO {
    private String nombreUsuario;
    private String nombre;
    private String apellido;
    private double saldo;

    public JugadorDTO(Jugador jugador) {
        this.nombre = jugador.getNombre();
        this.apellido = jugador.getApellido();
        this.nombreUsuario = jugador.getNombreUsuario();
        this.saldo = jugador.getSaldo();
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public double getSaldo() {
        return saldo;
    }
}
