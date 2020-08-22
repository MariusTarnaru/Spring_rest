package sda.spring.rest.service.exception;

public class EmailAlreadyUsedException extends Exception {

    public EmailAlreadyUsedException() {
        super("Email is already used");
    }
}
