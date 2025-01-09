package dev.othmanfr.exception;

/**
 * @author {Othman Fr}
 **/
public class InvalidAmountException extends RuntimeException{
    public InvalidAmountException(String message) {
        super(message);
    }
}
