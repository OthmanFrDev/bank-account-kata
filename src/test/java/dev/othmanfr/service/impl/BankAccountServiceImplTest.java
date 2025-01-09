package dev.othmanfr.service.impl;

import dev.othmanfr.dto.request.CreateBankAccountRequest;
import dev.othmanfr.dto.response.CreateBankAccountResponse;
import dev.othmanfr.exception.InsufficientBalanceException;
import dev.othmanfr.exception.InvalidAmountException;
import dev.othmanfr.exception.RequiredFieldException;
import dev.othmanfr.model.AccountType;
import dev.othmanfr.model.BankAccount;
import dev.othmanfr.model.Currency;
import dev.othmanfr.service.BankAccountService;
import dev.othmanfr.service.PrinterService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

/**
 * @author {}
 **/
class BankAccountServiceImplTest {
    private BankAccountService bankAccountService;
    private PrinterService printerService;
    @BeforeEach
    void setUp() {
        printerService=new ConsolePrinterServiceImpl();
        bankAccountService=new BankAccountServiceImpl(printerService);
    }

    @Test
    void should_create_bank_account_when_all_fields_provided() {
        CreateBankAccountRequest createBankAccountRequest=new CreateBankAccountRequest("ClientTest", AccountType.SAVING, Currency.EUR);
        CreateBankAccountResponse bankAccount = bankAccountService.createBankAccount(createBankAccountRequest);
        Assertions.assertNotNull(bankAccount.accountNumber());
        Assertions.assertEquals(bankAccount.balance(),0);
    }
    @Test
    void should_not_create_bank_account_when_fields_missing() {
        Assertions.assertThrows(RequiredFieldException.class,()-> {
            CreateBankAccountRequest createBankAccountRequest=new CreateBankAccountRequest("clientTest",null,null);
            bankAccountService.createBankAccount(createBankAccountRequest);
        });
    }

    @Test
    void should_depose_when_amount_gt_zero() {
        BankAccount bankAccount=new BankAccount(UUID.randomUUID(),"Client",0,AccountType.SAVING,Currency.EUR);
        bankAccountService.depose(bankAccount,1000);
        Assertions.assertEquals(bankAccount.getBalance(),1000);
    }
    @Test
    void should_not_depose_when_amount_lt_zero() {
        BankAccount bankAccount=new BankAccount(UUID.randomUUID(),"Client",0,AccountType.SAVING,Currency.EUR);
        Assertions.assertThrows(InvalidAmountException.class,()-> bankAccountService.depose(bankAccount,-1000));
    }

    @Test
    void should_withdraw_when_amount_lt_balance() {
        BankAccount bankAccount=new BankAccount(UUID.randomUUID(),"Client",1000,AccountType.SAVING,Currency.EUR);
        bankAccountService.withdraw(bankAccount,100);
        Assertions.assertEquals(bankAccount.getBalance(),900);
    }

    @Test
    void should_not_withdraw_when_amount_gt_balance() {
        BankAccount bankAccount=new BankAccount(UUID.randomUUID(),"Client",0,AccountType.SAVING,Currency.EUR);
        Assertions.assertThrows(InsufficientBalanceException.class,()->bankAccountService.withdraw(bankAccount,100));
    }

}