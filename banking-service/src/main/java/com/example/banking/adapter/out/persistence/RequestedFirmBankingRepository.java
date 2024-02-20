package com.example.banking.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestedFirmBankingRepository extends JpaRepository<RequestedFirmBankingJpaEntity, Long> {
}
