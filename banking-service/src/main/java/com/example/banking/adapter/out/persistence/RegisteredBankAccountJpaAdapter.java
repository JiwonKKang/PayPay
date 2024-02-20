package com.example.banking.adapter.out.persistence;

import com.example.banking.application.port.out.FindBankAccountPort;
import com.example.banking.application.port.out.RegisterBankAccountPort;
import com.example.banking.domain.RegisteredBankAccount;
import com.example.common.PersistenceAdapter;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class RegisteredBankAccountJpaAdapter implements RegisterBankAccountPort, FindBankAccountPort {

    private final RegisteredBankAccountRepository registeredBankAccountRepository;
    private final RegisteredBankAccountMapper registeredBankAccountMapper;

    @Override
    public RegisteredBankAccount registerBankAccount(RegisteredBankAccount registeredBankAccount) {
        RegisteredBankAccountJpaEntity jpaEntity = registeredBankAccountMapper.toJpaEntity(registeredBankAccount);
        RegisteredBankAccountJpaEntity saved = registeredBankAccountRepository.save(jpaEntity);
        return registeredBankAccountMapper.toDomainEntity(saved);
    }

    @Override
    public RegisteredBankAccount findBankAccount(Long registeredBankAccountId) {
        return registeredBankAccountRepository.findById(registeredBankAccountId)
                .map(registeredBankAccountMapper::toDomainEntity)
                .orElseThrow(() -> new EntityNotFoundException("Bank account not found"));
    }

    @Override
    public boolean existsRegisteredBankAccount(Long membershipId) {
        return registeredBankAccountRepository.existsByMembershipId(membershipId);
    }
}
