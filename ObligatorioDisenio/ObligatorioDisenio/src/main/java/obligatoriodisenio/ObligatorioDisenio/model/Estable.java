package obligatoriodisenio.ObligatorioDisenio.model;

public class Estable extends EstadoCarrera {

    @Override
    public String getNombre() {
        return "Estable";
    }

    @Override
    public boolean puedeApostar() {
        return true;
    }

    @Override
    public void cerrar(Carrera carrera) {
        carrera.cambiarEstado(new Cerrada());
    }

    @Override
    public void actualizarEstabilidad(Carrera carrera) {
        if (!carrera.todosDividendosValidos())
            carrera.cambiarEstado(new Abierta());
    }
}
