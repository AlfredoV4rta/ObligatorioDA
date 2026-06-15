package obligatoriodisenio.ObligatorioDisenio.config;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import obligatoriodisenio.ObligatorioDisenio.model.MalaPataException;

@RestControllerAdvice
public class ManejadorGlobalDeExcepciones {

    @ExceptionHandler(MalaPataException.class)
    public ResponseEntity<String> manejarMalaPata(MalaPataException ex) {
        return ResponseEntity.status(299).body(ex.getMessage());
    }
}
