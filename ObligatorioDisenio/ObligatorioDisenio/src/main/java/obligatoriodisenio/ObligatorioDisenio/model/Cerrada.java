package obligatoriodisenio.ObligatorioDisenio.model;

public class Cerrada extends EstadoCarrera {

    @Override
    public String getNombre() {
        return "Cerrada";
    }

    @Override
    public void finalizar(Carrera carrera, Participacion ganador) throws MalaPataException {
        if (ganador == null)
            throw new MalaPataException("Debe indicar el caballo ganador de la carrera");
        carrera.asignarGanador(ganador);
        carrera.marcarFinalizacion();
        carrera.cambiarEstado(new Finalizada());
    }
}
