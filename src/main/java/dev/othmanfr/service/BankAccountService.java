package dev.othmanfr.service;

import dev.othmanfr.dto.request.CreateBankAccountRequest;
import dev.othmanfr.dto.response.CreateBankAccountResponse;
import dev.othmanfr.model.BankAccount;

/**
 * @author {Othman Fr}
 **/
public interface BankAccountService {
    CreateBankAccountResponse createBankAccount(CreateBankAccountRequest createBankAccountRequest);
    void depose(BankAccount account, double amount);
    void withdraw(BankAccount account, double amount);
}
