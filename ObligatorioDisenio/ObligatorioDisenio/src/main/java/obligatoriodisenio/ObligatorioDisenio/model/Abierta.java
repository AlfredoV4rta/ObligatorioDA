package obligatoriodisenio.ObligatorioDisenio.model;

public class Abierta extends EstadoCarrera {

    @Override
    public String getNombre() {
        return "Abierta";
    }

    @Override
    public boolean puedeApostar() {
        return true;
    }

    @Override
    public void actualizarEstabilidad(Carrera carrera) {
        if (carrera.todosDividendosValidos())
            carrera.cambiarEstado(new Estable());
    }
}
