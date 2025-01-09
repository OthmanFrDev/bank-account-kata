package dev.othmanfr;

import dev.othmanfr.model.AccountType;
import dev.othmanfr.model.BankAccount;
import dev.othmanfr.model.Currency;
import dev.othmanfr.service.BankAccountService;
import dev.othmanfr.service.PrinterService;
import dev.othmanfr.service.impl.BankAccountServiceImpl;
import dev.othmanfr.service.impl.ConsolePrinterServiceImpl;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

/**
 * @author {Othman Fr}
 **/
@Slf4j
public class BankApplication {
    public static void main(String[] args) {
        BankAccountService bankAccountService=new BankAccountServiceImpl(new ConsolePrinterServiceImpl());
        BankAccount account=new BankAccount();
        account.setAccountNumber(UUID.randomUUID());
        account.setAccountHolderName("Client 1");
        account.setAccountType(AccountType.SAVING);
        account.setCurrency(Currency.EUR);
        bankAccountService.depose(account, 1000);
        bankAccountService.withdraw(account,100);
    }
}
