package dev.othmanfr.dto.response;

import java.util.UUID;

/**
 * @author {Othman Fr}
 **/
public record CreateBankAccountResponse(UUID accountNumber, String accountHolderName, double balance) {
}
