package obligatoriodisenio.ObligatorioDisenio.model;

import java.util.ArrayList;
import java.util.List;

public class Jugador extends Usuario {
    private double saldo;
    private List<Apuesta> apuestas;

    public Jugador() {
        this.apuestas = new ArrayList<>();
    }

    public Jugador(double saldo) {
        this();
        this.saldo = saldo;
    }

    public Jugador(String nombreUsuario, String contrasenia, String nombre, String apellido, double saldo) {
    super(nombreUsuario, contrasenia, nombre, apellido);
    this.saldo = saldo;
    this.apuestas = new ArrayList<>();
    }

    public double getSaldo() {
        return saldo;
    }

    public List<Apuesta> getApuestas() {
        return apuestas;
    }

    public void agregarApuesta(Apuesta apuesta) {
        this.apuestas.add(apuesta);
    }

    public void removerApuesta(Apuesta apuesta) {
        this.apuestas.remove(apuesta);
    }
}
