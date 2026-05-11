package obligatoriodisenio.ObligatorioDisenio.model;

import java.util.ArrayList;
import java.util.List;

public class Modalidad {
    private String nombre;
    private List<Apuesta> apuestas;

    public Modalidad() {
        this.apuestas = new ArrayList<>();
    }

    public Modalidad(String nombre) {
        this();
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Apuesta> getApuestas() {
        return apuestas;
    }

    public void setApuestas(List<Apuesta> apuestas) {
        this.apuestas = apuestas;
    }

    public void agregarApuesta(Apuesta apuesta) {
        this.apuestas.add(apuesta);
    }

    public void removerApuesta(Apuesta apuesta) {
        this.apuestas.remove(apuesta);
    }
}
