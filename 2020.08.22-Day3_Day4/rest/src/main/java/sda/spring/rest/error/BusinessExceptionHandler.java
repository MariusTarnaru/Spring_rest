package sda.spring.rest.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import sda.spring.rest.service.exception.EmailAlreadyUsedException;
import sda.spring.rest.service.exception.UserNotFoundException;

import java.util.Date;

@ControllerAdvice
public class BusinessExceptionHandler {

    @ExceptionHandler(EmailAlreadyUsedException.class)
    public ResponseEntity emailAlreadyUsedException(EmailAlreadyUsedException businessException,
                                                    WebRequest webRequest) {
        ErrorDetails errorDetails = getErrorDetails(webRequest,
                businessException.getMessage(),
                businessException.getClass().getSimpleName());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorDetails);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity emailAlreadyUsedException(UserNotFoundException businessException,
                                                    WebRequest webRequest) {
        ErrorDetails errorDetails = getErrorDetails(webRequest,
                businessException.getMessage(),
                businessException.getClass().getSimpleName());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDetails);
    }

    private ErrorDetails getErrorDetails(WebRequest webRequest, String message, String simpleName) {
        return new ErrorDetails()
                .setMessage(message)
                .setDetails(webRequest.getDescription(false))
                .setTimestamp(new Date())
                .setValidationType(simpleName);
    }

}
