package sda.spring.rest.service.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException() {
        super("User could not be found");
    }
}
