package obligatoriodisenio.ObligatorioDisenio.Presentadores;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.SessionScope;

import jakarta.servlet.http.HttpSession;
import obligatoriodisenio.ObligatorioDisenio.model.Fachada;
import obligatoriodisenio.ObligatorioDisenio.Presentadores.Command;
import obligatoriodisenio.ObligatorioDisenio.Presentadores.Commands;

@RestController
@RequestMapping("/tableroJugador")
@SessionScope
public class PresentadorTableroJugador {
    private Fachada fachada;

    public PresentadorTableroJugador(Fachada fachada) {
        this.fachada = fachada;
    }

    @PostMapping("/obtenerTablero")
    public Command obtenerTablero(HttpSession session) {
        return new Command("obtenerTablero", "");  
    }

    public Command mostrarTablero() {
        return new Command("mostrarTablero", "");
    }

    public Command mensajeError(String mensaje) {
        return new Command("mensajeError", mensaje);
    }
}
