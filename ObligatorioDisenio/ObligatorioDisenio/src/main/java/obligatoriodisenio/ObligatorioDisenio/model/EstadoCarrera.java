package obligatoriodisenio.ObligatorioDisenio.model;

public abstract class EstadoCarrera {

    public void abrir(Carrera carrera) throws MalaPataException {
        throw new MalaPataException("No se puede abrir esta carrera");
    }

    public void cerrar(Carrera carrera) throws MalaPataException {
        throw new MalaPataException("No es posible cerrar esta carrera");
    }

    public void finalizar(Carrera carrera, Participacion ganador) throws MalaPataException {
        throw new MalaPataException("No se puede finalizar esta carrera");
    }

    public void actualizarEstabilidad(Carrera carrera) {
    }

    public boolean puedeApostar() {
        return false;
    }

    public abstract String getNombre();
}
