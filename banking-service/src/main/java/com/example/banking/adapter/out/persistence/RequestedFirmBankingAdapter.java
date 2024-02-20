package com.example.banking.adapter.out.persistence;

import com.example.banking.application.port.out.RequestFirmBankingPort;
import com.example.banking.domain.RequestedFirmBanking;
import com.example.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

@PersistenceAdapter
@RequiredArgsConstructor
public class RequestedFirmBankingAdapter implements RequestFirmBankingPort {

    private final RequestedFirmBankingRepository requestedFirmBankingRepository;
    private final RequestedFirmBankingMapper requestedFirmBankingMapper;

    @Override
    public RequestedFirmBanking createRequestedFirmBanking(RequestedFirmBanking requestedFirmBanking) {
        RequestedFirmBankingJpaEntity jpaEntity = requestedFirmBankingMapper.toJpaEntity(requestedFirmBanking);
        RequestedFirmBankingJpaEntity res = requestedFirmBankingRepository.save(jpaEntity);
        return requestedFirmBankingMapper.toDomainEntity(res);
    }

    @Override
    public RequestedFirmBanking updateRequestedFirmBanking(RequestedFirmBanking requestedFirmBanking) {
        RequestedFirmBankingJpaEntity jpaEntity = requestedFirmBankingMapper.toJpaEntity(requestedFirmBanking);
        RequestedFirmBankingJpaEntity res = requestedFirmBankingRepository.save(jpaEntity);
        return requestedFirmBankingMapper.toDomainEntity(res);
    }
}
