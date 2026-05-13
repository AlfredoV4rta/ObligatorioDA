package obligatoriodisenio.ObligatorioDisenio.Presentadores;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;
import obligatoriodisenio.ObligatorioDisenio.model.Fachada;
import obligatoriodisenio.ObligatorioDisenio.model.Usuario;

@RestController
@RequestMapping("/auth")
public class PresentadorLogin {
    
    private Fachada fachada;

    public PresentadorLogin(Fachada fachada) {
        this.fachada = fachada;
    }

    @PostMapping("/login")
    public Commands login(@RequestParam String nombreUsuario, @RequestParam String contrasenia, HttpSession session) {
        Usuario usuario = fachada.login(nombreUsuario, contrasenia);
        
        if (usuario == null) {
            return Commands.create(
                new Command("mensajeError", "Credenciales inválidas")
            );
        }
        
        session.setAttribute("usuario", usuario);
        return Commands.create(
            new Command("accesoPermitido", "Login exitoso")
        );
    }

    @PostMapping("/logout")
    public Commands logout(HttpSession session) {
        session.invalidate();
        return Commands.create(
            new Command("sesionFinalizada", "Sesión cerrada")
        );
    }
}
