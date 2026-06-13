package obligatoriodisenio.ObligatorioDisenio.presentadores;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import jakarta.servlet.http.HttpSession;
import obligatoriodisenio.ObligatorioDisenio.model.Fachada;
import obligatoriodisenio.ObligatorioDisenio.model.Jugador;
import obligatoriodisenio.ObligatorioDisenio.observador.Observable;
import obligatoriodisenio.ObligatorioDisenio.observador.Observador;
import obligatoriodisenio.ObligatorioDisenio.DTOs.ApuestaDTO;
import obligatoriodisenio.ObligatorioDisenio.DTOs.CarreraDTO;
import obligatoriodisenio.ObligatorioDisenio.DTOs.JugadorDTO;
import obligatoriodisenio.ObligatorioDisenio.DTOs.ModalidadDTO;

@RestController
@RequestMapping("/tableroJugador")
@SessionScope
public class PresentadorTableroJugador implements Observador {
    private Fachada fachada;
    private ConexionNavegador conexionNavegador;
    private Jugador jugador;

    public PresentadorTableroJugador(Fachada fachada, ConexionNavegador conexionNavegador) {
        this.fachada = fachada;
        this.conexionNavegador = conexionNavegador;
    }

    @GetMapping(value = "/registrarSSE", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public SseEmitter registrarSSE() {
        conexionNavegador.conectarSSE();
        return conexionNavegador.getConexionSSE();
    }

    @PostMapping("/inicio")
    public Commands inicio(HttpSession session) {
        this.jugador = (Jugador) session.getAttribute("usuario");
        fachada.agregarObservador(this);
        return Commands.create(infoJugador(), tiposApuesta(), carrerasDisponibles(), apuestasUsuario());
    }

    @PostMapping("/fin")
    public Commands fin(HttpSession session) {
        fachada.quitarObservador(this);
        return Commands.create();
    }

    private Command infoJugador() {
        return new Command("infoJugador", new JugadorDTO(jugador));
    }

    private Command tiposApuesta() {
        return new Command("tiposApuesta", ModalidadDTO.fromList(fachada.obtenerTiposApuesta()));
    }

    private Command carrerasDisponibles() {
        return new Command("carrerasDisponibles", CarreraDTO.fromList(fachada.obtenerCarrerasDisponibles()));
    }

    private Command apuestasUsuario() {
        return new Command("apuestasUsuario",
                ApuestaDTO.fromList(fachada.obtenerApuestasUsuario(jugador.getNombreUsuario())));
    }

    @Override
    public void actualizar(Observable origen, Object evento) {
        conexionNavegador.enviarJSON(
                Commands.create(infoJugador(), carrerasDisponibles(), apuestasUsuario()));
    }
}
