package obligatoriodisenio.ObligatorioDisenio.datosPrueba;

import java.time.LocalDate;

import obligatoriodisenio.ObligatorioDisenio.model.Administrador;
import obligatoriodisenio.ObligatorioDisenio.model.Fachada;
import obligatoriodisenio.ObligatorioDisenio.model.Jornada;
import obligatoriodisenio.ObligatorioDisenio.model.Jugador;
import obligatoriodisenio.ObligatorioDisenio.model.Usuario;

public class Datos {

    public static void cargar() {
        Fachada fachada = Fachada.getInstance();

        // Administradores
        fachada.registrarAdministrador(new Administrador("a1", "a1", "Usuario", "Administrador"));
        fachada.registrarAdministrador(new Administrador("a2", "a2", "Admin", "Dos"));

        // Jugadores
        fachada.registrarJugador(new Jugador("j1", "j1", "Usuario", "Jugador", 2000));
        fachada.registrarJugador(new Jugador("j2", "j2", "Jugador", "Dos", 5000));

        // Jornadas
        Jornada hoy = new Jornada(LocalDate.now());
        Jornada pasada = new Jornada(LocalDate.now().minusWeeks(1));
        Jornada futura = new Jornada(LocalDate.now().plusWeeks(1));
    }
}