package obligatoriodisenio.ObligatorioDisenio.datosPrueba;

import obligatoriodisenio.ObligatorioDisenio.model.Administrador;
import obligatoriodisenio.ObligatorioDisenio.model.Fachada;
import obligatoriodisenio.ObligatorioDisenio.model.Usuario;

public class Datos {

    public static void cargar() {
        Fachada fachada = Fachada.getInstance();

        // Administradores
        fachada.registrarAdministrador(new Administrador("a1", "a1", "Usuario", "Administrador"));
        fachada.registrarAdministrador(new Administrador("a2", "a2", "Admin", "Dos"));

        // Jugadores
        Usuario j1 = new Usuario("j1", "j1", "Usuario", "Jugador");
        fachada.registrarUsuario(j1);

        Usuario j2 = new Usuario("j2", "j2", "Jugador", "Dos");
        fachada.registrarUsuario(j2);
    }
}