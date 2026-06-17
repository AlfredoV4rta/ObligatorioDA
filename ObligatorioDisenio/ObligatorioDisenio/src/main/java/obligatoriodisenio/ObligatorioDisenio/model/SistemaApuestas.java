package obligatoriodisenio.ObligatorioDisenio.model;

import java.util.ArrayList;
import java.util.List;

public class SistemaApuestas {
    private List<Apuesta> apuestas;
    private double comision;

    public SistemaApuestas() {
        this.apuestas = new ArrayList<>();
        this.comision = 0.10;
    }

    public double getComision() {
        return comision;
    }

    public void agregarApuesta(Apuesta apuesta) {
        apuestas.add(apuesta);
    }

    public List<Apuesta> getApuestas() {
        return apuestas;
    }

    public void registrarApuesta(Jugador jugador, Participacion participacion, Modalidad modalidad,
        double monto, String password) throws MalaPataException {

    if (!jugador.validarContrasenia(password))
        throw new MalaPataException("Contraseña incorrecta");
    if (monto < 1)
        throw new MalaPataException("Monto inválido");

    Carrera carrera = participacion.getCarrera();
    if (!carrera.estaDisponible())
        throw new MalaPataException("Esta carrera ya no recibe apuestas");

    double costo = modalidad.calcularCosto(monto);
    if (jugador.getSaldo() < costo)
        throw new MalaPataException("Saldo insuficiente");

    Apuesta apuesta = new Apuesta(jugador, participacion, modalidad, monto);
    jugador.descontarSaldo(costo);
    jugador.agregarApuesta(apuesta);
    participacion.agregarApuesta(apuesta);
    apuestas.add(apuesta);

    carrera.recalcularDividendos(comision);
    carrera.actualizarEstabilidad();
}
}
