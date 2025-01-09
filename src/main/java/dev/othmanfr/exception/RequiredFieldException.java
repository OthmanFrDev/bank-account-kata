package dev.othmanfr.exception;

/**
 * @author {Othman fr}
 **/
public class RequiredFieldException extends RuntimeException{
    public RequiredFieldException(String message) {
        super(message);
    }
}
