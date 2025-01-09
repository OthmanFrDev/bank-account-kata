package dev.othmanfr.service.impl;

import dev.othmanfr.model.BankAccountStatement;
import dev.othmanfr.service.PrinterService;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * @author {Othman Fr}
 **/
public class ConsolePrinterServiceImpl implements PrinterService {
    @Override
    public void printStatement(BankAccountStatement bankAccountStatement) {
        System.out.println("============== Account Statement ==============");
        System.out.println("Operation : "+bankAccountStatement.getOperationType().name());
        System.out.println("amount : "+bankAccountStatement.getAmount());
        System.out.println("Current Balance : "+bankAccountStatement.getBalance());
        System.out.println("Date : "+ LocalDateTime.ofInstant(bankAccountStatement.getDate(), ZoneOffset.UTC));
        System.out.println("===============================================");
    }
}
