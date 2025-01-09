package dev.othmanfr.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * @author {Othman Fr}
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankAccount {
    private UUID accountNumber;
    private String accountHolderName;
    private double balance;
    private AccountType accountType;
    private Currency currency;
}
