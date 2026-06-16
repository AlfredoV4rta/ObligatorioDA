package obligatoriodisenio.ObligatorioDisenio.model;

public class Definida extends EstadoCarrera {

    @Override
    public String getNombre() {
        return "Definida";
    }

    @Override
    public void abrir(Carrera carrera) {
        carrera.cambiarEstado(new Abierta());
    }
}
