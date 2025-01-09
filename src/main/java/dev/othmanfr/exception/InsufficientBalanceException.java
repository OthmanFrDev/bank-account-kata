package dev.othmanfr.exception;

/**
 * @author {Othman Fr}
 **/
public class InsufficientBalanceException extends RuntimeException{
    public InsufficientBalanceException(String message) {
        super(message);
    }
}
