package obligatoriodisenio.ObligatorioDisenio.Presentadores;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;
import obligatoriodisenio.ObligatorioDisenio.model.Administrador;
import obligatoriodisenio.ObligatorioDisenio.model.Fachada;
import obligatoriodisenio.ObligatorioDisenio.model.Jugador;
import obligatoriodisenio.ObligatorioDisenio.model.Usuario;
import obligatoriodisenio.ObligatorioDisenio.Presentadores.Command;
import obligatoriodisenio.ObligatorioDisenio.Presentadores.Commands;

@RestController
public class PresentadorLogin {

    private Fachada fachada;

    public PresentadorLogin(Fachada fachada) {
        this.fachada = fachada;
    }

    @GetMapping("/")
    public void raiz(jakarta.servlet.http.HttpServletResponse response)
            throws java.io.IOException {
        response.sendRedirect("/login.html");
    }

    @PostMapping("/login")
    public Commands login(@RequestParam String nombreUsuario,
            @RequestParam String contrasenia,
            HttpSession session) {
        Jugador jugador = fachada.buscarJugador(nombreUsuario, contrasenia);
        if (jugador != null) {
            session.setAttribute("usuario", jugador);
            return Commands.create(new Command("accesoJugador", ""));
        }

        Administrador admin = fachada.buscarAdministrador(nombreUsuario, contrasenia);
        if (admin != null) {
            session.setAttribute("usuario", admin);
            return Commands.create(new Command("accesoAdmin", ""));
        }
        return Commands.create(new Command("mensajeError", "Acceso denegado"));
    }

    @PostMapping("/logout")
    public Commands logout(HttpSession session) {
        session.invalidate();
        return Commands.create(
                new Command("sesionFinalizada", "Sesión cerrada"));
    }

    public Command accesoJugador() {
        return new Command("accesoJugador", "");
    }

    public Command accesoAdmin() {
        return new Command("accesoAdmin", "");
    }

    public Command mensajeError(String mensaje) {
        return new Command("mensajeError", mensaje);
    }
}
