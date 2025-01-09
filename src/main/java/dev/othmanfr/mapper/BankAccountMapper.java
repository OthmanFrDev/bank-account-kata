package dev.othmanfr.mapper;

import dev.othmanfr.dto.request.CreateBankAccountRequest;
import dev.othmanfr.dto.response.CreateBankAccountResponse;
import dev.othmanfr.model.BankAccount;

import java.util.UUID;

/**
 * @author {Othman Fr}
 **/
public final class BankAccountMapper {
    private BankAccountMapper(){
    }
    public static BankAccount toEntity(CreateBankAccountRequest createBankAccountRequest){
        BankAccount bA=new BankAccount();
        bA.setAccountNumber(UUID.randomUUID());
        bA.setAccountType(createBankAccountRequest.accountType());
        bA.setAccountHolderName(createBankAccountRequest.accountHolderName());
        bA.setCurrency(createBankAccountRequest.currency());
        return bA;
    }
    public static CreateBankAccountResponse toResponse(BankAccount bankAccount){
        return new CreateBankAccountResponse(bankAccount.getAccountNumber(), bankAccount.getAccountHolderName(), bankAccount.getBalance());
    }
}
