package dev.othmanfr.service.impl;

import dev.othmanfr.dto.request.CreateBankAccountRequest;
import dev.othmanfr.dto.response.CreateBankAccountResponse;
import dev.othmanfr.exception.InsufficientBalanceException;
import dev.othmanfr.exception.InvalidAmountException;
import dev.othmanfr.mapper.BankAccountMapper;
import dev.othmanfr.model.BankAccount;
import dev.othmanfr.model.BankAccountStatement;
import dev.othmanfr.model.OperationType;
import dev.othmanfr.service.BankAccountService;
import dev.othmanfr.service.PrinterService;
import lombok.extern.slf4j.Slf4j;

import java.time.Instant;

/**
 * @author {Othman Fr}
 **/
@Slf4j
public class BankAccountServiceImpl implements BankAccountService {
    private final PrinterService printerService;

    public BankAccountServiceImpl(PrinterService printerService) {
        this.printerService = printerService;
    }


    @Override
    public CreateBankAccountResponse createBankAccount(CreateBankAccountRequest createBankAccountRequest) {
        log.info("Creating bank account for client : {}", createBankAccountRequest.accountHolderName());
        BankAccount bankAccount = BankAccountMapper.toEntity(createBankAccountRequest);
        return BankAccountMapper.toResponse(bankAccount);
    }

    @Override
    public void depose(BankAccount account, double amount) {
        if(amount<=0){
            log.error("Invalid amount: {}", amount);
            throw new InvalidAmountException("The amount to add should be greater than zero.");
        }
        double newBalance = account.getBalance() + amount;
        account.setBalance(newBalance);
        log.info("Deposited amount: {}{}, Balance: {}{}", amount, account.getCurrency().getSymbol(), account.getBalance(),account.getCurrency().getSymbol());
        printBankStatement(account, amount, OperationType.DEPOSIT);
    }

    @Override
    public void withdraw(BankAccount account, double amount) {
        if(account.getBalance()<amount){
            log.error("Insufficient balance.");
            throw new InsufficientBalanceException("Insufficient balance. Your current balance is " + account.getBalance() + ".");
        }
        account.setBalance(account.getBalance()-amount);
        log.info("Withdrew amount: {}. Balance: {}", amount, account.getBalance());
        printBankStatement(account, amount, OperationType.WITHDRAWAL);
    }

    private void printBankStatement(BankAccount account, double amount, OperationType operationType) {
        BankAccountStatement bankAccountStatement=new BankAccountStatement(amount, account.getBalance(), operationType, Instant.now());
        printerService.printStatement(bankAccountStatement);
    }
}
