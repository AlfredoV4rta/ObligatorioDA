package obligatoriodisenio.ObligatorioDisenio.presentadores;

import java.util.ArrayList;
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
import obligatoriodisenio.ObligatorioDisenio.model.Administrador;
import obligatoriodisenio.ObligatorioDisenio.model.Carrera;
import obligatoriodisenio.ObligatorioDisenio.model.Fachada;
import obligatoriodisenio.ObligatorioDisenio.model.Jornada;
import obligatoriodisenio.ObligatorioDisenio.model.MalaPataException;
import obligatoriodisenio.ObligatorioDisenio.model.Participacion;
import obligatoriodisenio.ObligatorioDisenio.observador.Observable;
import obligatoriodisenio.ObligatorioDisenio.observador.Observador;
import obligatoriodisenio.ObligatorioDisenio.DTOs.CarreraAdminDTO;
import obligatoriodisenio.ObligatorioDisenio.DTOs.TableroAdminDTO;

@RestController
@RequestMapping("/tableroAdmin")
@SessionScope
public class PresentadorTableroAdmin implements Observador {
    private Fachada fachada;
    private ConexionNavegador conexionNavegador;
    private Administrador admin;
    private Jornada jornadaMostrada;
    private List<Carrera> carrerasJornada;

    public PresentadorTableroAdmin(Fachada fachada, ConexionNavegador conexionNavegador) {
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
        if (!(usuario instanceof Administrador)) {
            return Commands.create(new Command("sesionFinalizada", ""));
        }
        this.admin = (Administrador) usuario;
        this.jornadaMostrada = fachada.getJornadaActual();
        fachada.agregarObservador(this);
        return Commands.create(infoAdmin(), tablero(), carreras());
    }

    @PostMapping("/fin")
    public Commands fin(HttpSession session) {
        fachada.quitarObservador(this);
        return Commands.create();
    }

    @PostMapping("/avanzar")
    public Commands avanzar() {
        if (jornadaMostrada != null) {
            jornadaMostrada = fachada.jornadaSiguiente(jornadaMostrada);
        }
        return Commands.create(tablero(), carreras());
    }

    @PostMapping("/retroceder")
    public Commands retroceder() {
        if (jornadaMostrada != null) {
            jornadaMostrada = fachada.jornadaAnterior(jornadaMostrada);
        }
        return Commands.create(tablero(), carreras());
    }

    @PostMapping("/abrir")
    public Commands abrir(@RequestParam int posCarrera) throws MalaPataException {
        fachada.abrirCarrera(carrerasJornada.get(posCarrera));
        return Commands.create(new Command("accionRealizada", ""));
    }

    @PostMapping("/cerrar")
    public Commands cerrar(@RequestParam int posCarrera) throws MalaPataException {
        fachada.cerrarCarrera(carrerasJornada.get(posCarrera));
        return Commands.create(new Command("accionRealizada", ""));
    }

    @PostMapping("/finalizar")
    public Commands finalizar(@RequestParam int posCarrera, @RequestParam int posGanador) throws MalaPataException {
        Carrera carrera = carrerasJornada.get(posCarrera);
        Participacion ganador = (posGanador >= 0) ? carrera.getParticipaciones().get(posGanador) : null;
        fachada.finalizarCarrera(carrera, ganador);
        return Commands.create(new Command("accionRealizada", ""));
    }

    private Command infoAdmin() {
        return new Command("infoAdmin", admin.getNombreCompleto());
    }

    private Command tablero() {
        return new Command("tablero", new TableroAdminDTO(jornadaMostrada, fachada.getComision()));
    }

    private Command carreras() {
        this.carrerasJornada = (jornadaMostrada != null) ? jornadaMostrada.getCarreras() : new ArrayList<>();
        return new Command("carreras", CarreraAdminDTO.fromList(carrerasJornada));
    }

    @Override
    public void actualizar(Observable origen, Object evento) {
        conexionNavegador.enviarJSON(Commands.create(tablero(), carreras()));
    }
}
