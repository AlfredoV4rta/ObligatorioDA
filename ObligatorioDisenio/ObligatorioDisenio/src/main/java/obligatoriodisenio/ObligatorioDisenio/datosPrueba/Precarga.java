package obligatoriodisenio.ObligatorioDisenio.datosPrueba;

import java.time.LocalDate;
import java.util.List;

import obligatoriodisenio.ObligatorioDisenio.model.Administrador;
import obligatoriodisenio.ObligatorioDisenio.model.Caballo;
import obligatoriodisenio.ObligatorioDisenio.model.Carrera;
import obligatoriodisenio.ObligatorioDisenio.model.Fachada;
import obligatoriodisenio.ObligatorioDisenio.model.Jornada;
import obligatoriodisenio.ObligatorioDisenio.model.Jugador;
import obligatoriodisenio.ObligatorioDisenio.model.MalaPataException;
import obligatoriodisenio.ObligatorioDisenio.model.Modalidad;
import obligatoriodisenio.ObligatorioDisenio.model.Participacion;
import obligatoriodisenio.ObligatorioDisenio.model.Simple;
import obligatoriodisenio.ObligatorioDisenio.model.Super;
import obligatoriodisenio.ObligatorioDisenio.model.Triple;

public class Precarga {

    public static void cargar() {
        Fachada f = Fachada.getInstance();

        // ===== Administradores =====
        f.registrarAdministrador(new Administrador("a1", "a1", "Usuario", "Administrador"));
        f.registrarAdministrador(new Administrador("mgomez", "mgomez", "Marta", "Gómez"));

        // ===== Jugadores =====
        Jugador j1 = new Jugador("j1", "j1", "Usuario", "Jugador", 2000);
        Jugador lucia = new Jugador("lmartinez", "lmartinez", "Lucía", "Martínez", 50000);
        Jugador javier = new Jugador("jrodriguez", "jrodriguez", "Javier", "Rodríguez", 48000);
        Jugador sofia = new Jugador("spereyra", "spereyra", "Sofía", "Pereyra", 55000);
        Jugador diego = new Jugador("dfernandez", "dfernandez", "Diego", "Fernández", 60000);
        Jugador camila = new Jugador("cgonzalez", "cgonzalez", "Camila", "González", 45000);
        Jugador nicolas = new Jugador("ntorres", "ntorres", "Nicolás", "Torres", 52000);
        Jugador valentina = new Jugador("vsuarez", "vsuarez", "Valentina", "Suárez", 47000);
        for (Jugador j : List.of(j1, lucia, javier, sofia, diego, camila, nicolas, valentina)) {
            f.registrarJugador(j);
        }
        List<Jugador> apostadores = List.of(lucia, javier, sofia, diego, camila, nicolas, valentina);

        // ===== Caballos =====
        Caballo rayo = new Caballo("Rayo Amarillo");
        Caballo veloz = new Caballo("Veloz Tormenta");
        Caballo rice = new Caballo("Rice Shower");
        Caballo gold = new Caballo("Gold Ship");
        Caballo tormentaSur = new Caballo("Tormenta del Sur");
        Caballo vientoPampeano = new Caballo("Viento Pampeano");
        Caballo donCornelio = new Caballo("Don Cornelio");
        Caballo laEstrella = new Caballo("La Estrella");
        Caballo relampago = new Caballo("Relámpago Real");
        Caballo truenoNegro = new Caballo("Trueno Negro");
        Caballo brisaMarina = new Caballo("Brisa Marina");
        Caballo lucero = new Caballo("Lucero del Alba");
        Caballo furia = new Caballo("Furia Criolla");
        Caballo pampaBrava = new Caballo("Pampa Brava");
        Caballo centella = new Caballo("Centella");
        Caballo nubeBlanca = new Caballo("Nube Blanca");

        // ===== Jornada de HOY: 3 carreras Definidas (sin apuestas) =====
        Jornada hoy = new Jornada(LocalDate.now());
        f.crearJornada(hoy);
        crearCarrera(hoy, 1, "Gran Premio del Litoral", rayo, veloz, rice, donCornelio, tormentaSur);
        crearCarrera(hoy, 2, "Clásico Río de la Plata", gold, laEstrella, vientoPampeano, relampago);
        crearCarrera(hoy, 3, "Copa San Martín", truenoNegro, brisaMarina, lucero, furia, pampaBrava);

        // ===== Jornada de la SEMANA PASADA: 2 Cerradas (con apuestas) + 1 Finalizada (extra) =====
        Jornada pasada = new Jornada(LocalDate.now().minusWeeks(1));
        f.crearJornada(pasada);
        Carrera cp1 = crearCarrera(pasada, 1, "Premio Apertura", centella, nubeBlanca, rayo, pampaBrava);
        Carrera cp2 = crearCarrera(pasada, 2, "Handicap de Otoño", rice, gold, veloz, laEstrella, donCornelio);
        Carrera cp3 = crearCarrera(pasada, 3, "Clásico de Invierno", tormentaSur, vientoPampeano, relampago, truenoNegro);
        cerrarConApuestas(f, cp1, apostadores, 14);
        cerrarConApuestas(f, cp2, apostadores, 16);
        finalizarConApuestas(f, cp3, apostadores, 12, 0);

        // ===== Jornada de la SEMANA PRÓXIMA: 1 carrera Definida =====
        Jornada futura = new Jornada(LocalDate.now().plusWeeks(1));
        f.crearJornada(futura);
        crearCarrera(futura, 1, "Gran Premio Clausura", rayo, veloz, gold, tormentaSur);

        System.out.println("Precarga MalaPATA lista: 2 admins, 8 jugadores, 16 caballos, 3 jornadas.");
    }

    private static Carrera crearCarrera(Jornada jornada, int nro, String nombre, Caballo... caballos) {
        Carrera carrera = new Carrera(nro, nombre, jornada);
        int numero = 1;
        for (Caballo caballo : caballos) {
            Participacion participacion = new Participacion(numero++, caballo, carrera);
            carrera.agregarParticipacion(participacion);
            caballo.agregarParticipacion(participacion);
        }
        jornada.agregarCarrera(carrera);
        return carrera;
    }

    private static void cerrarConApuestas(Fachada f, Carrera carrera, List<Jugador> jugadores, int cantidad) {
        Modalidad[] modalidades = { new Simple(), new Triple(), new Super() };
        double[] montos = { 500, 700, 600, 800, 1000, 750, 650, 900 };
        try {
            carrera.abrir();
            List<Participacion> participaciones = carrera.getParticipaciones();
            for (int i = 0; i < cantidad; i++) {
                Jugador jugador = jugadores.get(i % jugadores.size());
                Participacion participacion = participaciones.get(i % participaciones.size());
                Modalidad modalidad = modalidades[i % modalidades.length];
                double monto = montos[i % montos.length];
                f.registrarApuesta(jugador, participacion, modalidad, monto, jugador.getContrasenia());
            }
            carrera.cerrar();
        } catch (MalaPataException e) {
            System.out.println("Precarga (cerrarConApuestas) falló: " + e.getMessage());
        }
    }

    private static void finalizarConApuestas(Fachada f, Carrera carrera, List<Jugador> jugadores,
            int cantidad, int posGanador) {
        cerrarConApuestas(f, carrera, jugadores, cantidad);
        try {
            Participacion ganador = carrera.getParticipaciones().get(posGanador);
            f.finalizarCarrera(carrera, ganador);
        } catch (MalaPataException e) {
            System.out.println("Precarga (finalizarConApuestas) falló: " + e.getMessage());
        }
    }
}
