package ms.miscelanea.mati.address.config;

import ms.miscelanea.mati.address.dto.ErrorRequest;
import ms.miscelanea.mati.address.dto.MessageGenericDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(MessageGenericDto.class)
    public ResponseEntity<Object> resourceNotFoundException(MessageGenericDto ex, WebRequest request) {
        return new ResponseEntity<>(new ErrorRequest(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMensaje(), ex.getInfo(), ex.getStackTrace().toString()), ex.getCodigo());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> globalExceptionHandler(Exception ex, WebRequest request) {

        return new ResponseEntity<>(new ErrorRequest(HttpStatus.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR.name(), "Error interno el el servidor", ex.getStackTrace().toString()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
