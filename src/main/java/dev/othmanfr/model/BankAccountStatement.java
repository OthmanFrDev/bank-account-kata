package dev.othmanfr.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Instant;

/**
 * @author {Othman Fr}
 **/
@Getter
@AllArgsConstructor
public class BankAccountStatement {
    private double amount;
    private double balance;
    private OperationType operationType;
    private Instant date;
}
