package dev.othmanfr.service;

import dev.othmanfr.model.BankAccountStatement;

/**
 * @author {Othman Fr}
 **/
public interface PrinterService {
    void printStatement(BankAccountStatement bankAccountStatement);
}
