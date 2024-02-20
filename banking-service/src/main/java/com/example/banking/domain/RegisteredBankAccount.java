package com.example.banking.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RegisteredBankAccount {

    private final Long registeredBankAccountId;
    private final Long membershipId;
    private final String bankName;
    private final String bankAccountNumber;
    private final boolean linkedStatusIsValid;

    public static RegisteredBankAccount generateRegisteredBankAccount(
            RegisteredBankAccountId registeredBankAccountId,
            MembershipId membershipId,
            BankName bankName,
            BankAccountNumber bankAccountNumber,
            LinkedStatusIsValid linkedStatusIsValid) {

        return new RegisteredBankAccount(
                registeredBankAccountId.registeredBankAccountId,
                membershipId.membershipId,
                bankName.bankName,
                bankAccountNumber.bankAccountNumber,
                linkedStatusIsValid.linkedStatusIsValid
        );
    }


    @AllArgsConstructor(staticName = "from")
    public static class RegisteredBankAccountId {
        Long registeredBankAccountId;

        public static RegisteredBankAccountId notAssigned() {
            return new RegisteredBankAccountId(null);
        }
    }

    @AllArgsConstructor(staticName = "from")
    public static class MembershipId {
        Long membershipId;
    }

    @AllArgsConstructor(staticName = "from")
    public static class BankName {
        String bankName;
    }

    @AllArgsConstructor(staticName = "from")
    public static class BankAccountNumber {
        String bankAccountNumber;
    }

    @AllArgsConstructor(staticName = "from")
    public static class LinkedStatusIsValid {
        boolean linkedStatusIsValid;
    }


}
