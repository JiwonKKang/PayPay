package com.example.banking.application.port.in;

import com.example.common.SelfValidating;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class RegisterBankAccountCommand extends SelfValidating<RegisterBankAccountCommand> {


    @NotNull
    private final Long membershipId;

    @NotNull
    private final String bankName;

    @NotNull
    private final String bankAccountNumber;

    @NotNull
    private final boolean linkedStatusIsValid;

    @Builder
    public RegisterBankAccountCommand(Long membershipId, String bankName, String bankAccountNumber, boolean linkedStatusIsValid) {
        this.membershipId = membershipId;
        this.bankName = bankName;
        this.bankAccountNumber = bankAccountNumber;
        this.linkedStatusIsValid = linkedStatusIsValid;
        this.validateSelf();
    }
}
