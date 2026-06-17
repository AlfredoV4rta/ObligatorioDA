package obligatoriodisenio.ObligatorioDisenio.presentadores;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import jakarta.servlet.http.HttpSession;
import obligatoriodisenio.ObligatorioDisenio.model.Carrera;
import obligatoriodisenio.ObligatorioDisenio.model.Fachada;
import obligatoriodisenio.ObligatorioDisenio.model.Jugador;
import obligatoriodisenio.ObligatorioDisenio.model.MalaPataException;
import obligatoriodisenio.ObligatorioDisenio.model.Modalidad;
import obligatoriodisenio.ObligatorioDisenio.model.Participacion;
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
    private List<Carrera> carrerasDisponibles;
    private List<Modalidad> tiposApuesta;

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
        Object usuario = session.getAttribute("usuario");
        if (!(usuario instanceof Jugador)) {
            return Commands.create(new Command("sesionFinalizada", ""));
        }
        this.jugador = (Jugador) usuario;
        fachada.agregarObservador(this);
        return Commands.create(infoJugador(), tiposApuesta(), carrerasDisponibles(), apuestasUsuario());
    }

    @PostMapping("/fin")
    public Commands fin(HttpSession session) {
        fachada.quitarObservador(this);
        return Commands.create();
    }

    @PostMapping("/apostar")
    public Commands apostar(@RequestParam int posCarrera, @RequestParam int posCaballo,
            @RequestParam int posModalidad, @RequestParam double monto,
            @RequestParam String password) throws MalaPataException {
        Carrera carrera = carrerasDisponibles.get(posCarrera);
        Participacion participacion = carrera.getParticipaciones().get(posCaballo);
        Modalidad modalidad = tiposApuesta.get(posModalidad);
        fachada.registrarApuesta(jugador, participacion, modalidad, monto, password);
        return Commands.create(new Command("apuestaConfirmada", ""));
    }

    private Command infoJugador() {
        return new Command("infoJugador", new JugadorDTO(jugador));
    }

    private Command tiposApuesta() {
        this.tiposApuesta = fachada.obtenerTiposApuesta();
        return new Command("tiposApuesta", ModalidadDTO.fromList(tiposApuesta));
    }

    private Command carrerasDisponibles() {
        this.carrerasDisponibles = fachada.obtenerCarrerasDisponibles();
        return new Command("carrerasDisponibles", CarreraDTO.fromList(carrerasDisponibles));
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
