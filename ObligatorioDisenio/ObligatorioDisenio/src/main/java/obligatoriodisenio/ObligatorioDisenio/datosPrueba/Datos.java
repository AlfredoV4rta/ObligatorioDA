package obligatoriodisenio.ObligatorioDisenio.datosPrueba;

import obligatoriodisenio.ObligatorioDisenio.model.Administrador;
import obligatoriodisenio.ObligatorioDisenio.model.Fachada;
import obligatoriodisenio.ObligatorioDisenio.model.Jugador;

public class Datos {

    public static void cargar() {
        Fachada fachada = Fachada.getInstance();

        // Administradores
        fachada.registrarAdministrador(new Administrador("a1", "a1", "Usuario", "Administrador"));
        fachada.registrarAdministrador(new Administrador("a2", "a2", "Admin", "Dos"));
        System.out.println("Administradores cargados.");
        
        Jugador j1 = new Jugador("j1", "j1", null, null, 0);
        j1.setSaldo(2000);
        fachada.registrarJugadores(j1);

        Jugador j2 = new Jugador("j2", "j2", null, null, 0);
        j2.setSaldo(5000);
        fachada.registrarJugadores(j2);
        System.out.println("Jugadores cargados.");
    }
}