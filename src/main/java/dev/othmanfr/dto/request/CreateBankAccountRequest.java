package dev.othmanfr.dto.request;

import dev.othmanfr.exception.RequiredFieldException;
import dev.othmanfr.model.AccountType;
import dev.othmanfr.model.Currency;

/**
 * @author {Othman Fr}
 **/
public record CreateBankAccountRequest(String accountHolderName, AccountType accountType, Currency currency) {
    public CreateBankAccountRequest{
        if(accountHolderName==null || accountType==null || currency==null){
            throw new RequiredFieldException("All fields are required (Account holder name, accountType, Currency).");
        }
    }
}
