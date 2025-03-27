package ir.digixo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//exception class if the entity is not found in the db
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends Exception {

    private static final long serialVersionUID = 1L;

    public EntityNotFoundException(final String message) {
        super(message);
    }
}