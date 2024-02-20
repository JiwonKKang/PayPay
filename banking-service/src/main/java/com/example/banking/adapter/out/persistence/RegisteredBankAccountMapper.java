package com.example.banking.adapter.out.persistence;

import com.example.banking.domain.RegisteredBankAccount;
import org.springframework.stereotype.Component;

@Component
public class RegisteredBankAccountMapper {

    public RegisteredBankAccountJpaEntity toJpaEntity(RegisteredBankAccount registeredBankAccount) {
        return RegisteredBankAccountJpaEntity.builder()
                .membershipId(registeredBankAccount.getMembershipId())
                .bankAccountNumber(registeredBankAccount.getBankAccountNumber())
                .bankName(registeredBankAccount.getBankName())
                .linkedStatusIsValid(registeredBankAccount.isLinkedStatusIsValid())
                .build();
    }

    public RegisteredBankAccount toDomainEntity(RegisteredBankAccountJpaEntity registeredBankAccountJpaEntity) {
        return RegisteredBankAccount.generateRegisteredBankAccount(
                RegisteredBankAccount.RegisteredBankAccountId.from(registeredBankAccountJpaEntity.getId()),
                RegisteredBankAccount.MembershipId.from(registeredBankAccountJpaEntity.getMembershipId()),
                RegisteredBankAccount.BankName.from(registeredBankAccountJpaEntity.getBankName()),
                RegisteredBankAccount.BankAccountNumber.from(registeredBankAccountJpaEntity.getBankAccountNumber()),
                RegisteredBankAccount.LinkedStatusIsValid.from(registeredBankAccountJpaEntity.isLinkedStatusIsValid())
        );
    }

}
