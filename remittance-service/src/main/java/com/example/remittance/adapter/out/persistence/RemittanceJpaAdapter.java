package com.example.remittance.adapter.out.persistence;

import com.example.common.PersistenceAdapter;
import com.example.remittance.application.port.out.RemittancePort;
import com.example.remittance.domain.Remittance;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class RemittanceJpaAdapter implements RemittancePort {

    private final RemittanceJpaRepository remittanceJpaRepository;
    private final RemittanceMapper remittanceMapper;

    @Override
    public Remittance saveRemittance(Remittance remittance) {
        RemittanceJpaEntity remittanceEntity = remittanceMapper.toEntity(remittance);
        RemittanceJpaEntity saved = remittanceJpaRepository.save(remittanceEntity);
        return remittanceMapper.toDomain(saved);
    }
}
