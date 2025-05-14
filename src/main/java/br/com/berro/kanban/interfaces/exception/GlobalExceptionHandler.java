package br.com.berro.kanban.interfaces.exception;

import br.com.berro.kanban.common.exception.ErrorResponse;
import br.com.berro.kanban.common.exception.NotFoundBusinessException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundBusinessException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundException(NotFoundBusinessException ex,
                                                                 HttpServletRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                "Not Found",
                ex.getMessage(),
                request.getRequestURI()
        );

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

}
