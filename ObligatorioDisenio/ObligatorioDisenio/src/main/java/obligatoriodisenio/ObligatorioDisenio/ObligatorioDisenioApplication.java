package obligatoriodisenio.ObligatorioDisenio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import obligatoriodisenio.ObligatorioDisenio.datosPrueba.Datos;

@SpringBootApplication
public class ObligatorioDisenioApplication {

	public static void main(String[] args) {
		Datos.cargar();
		SpringApplication.run(ObligatorioDisenioApplication.class, args);
	}

}
