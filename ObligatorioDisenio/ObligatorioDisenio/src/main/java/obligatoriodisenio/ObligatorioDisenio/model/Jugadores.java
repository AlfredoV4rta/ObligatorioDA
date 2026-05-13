package obligatoriodisenio.ObligatorioDisenio.model;

import java.util.ArrayList;
import java.util.List;

public class Jugadores {
    private double saldo;
    private List<Apuesta> apuestas;

    public Jugadores() {
        this.apuestas = new ArrayList<>();
    }

    public Jugadores(double saldo) {
        this();
        this.saldo = saldo;
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
