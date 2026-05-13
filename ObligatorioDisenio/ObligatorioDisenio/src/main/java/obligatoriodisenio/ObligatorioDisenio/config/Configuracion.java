package obligatoriodisenio.ObligatorioDisenio.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import obligatoriodisenio.ObligatorioDisenio.model.Fachada;

@Configuration
public class Configuracion {

    @Bean
    public Fachada fachada() {
        return Fachada.getInstance();
    }
}