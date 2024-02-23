package com.example.banking.adapter.out.persistence;

import com.example.banking.domain.RequestedFirmBanking;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RequestedFirmBankingMapper {

    public RequestedFirmBankingJpaEntity
    toJpaEntity(RequestedFirmBanking requestedFirmBanking) {
        return RequestedFirmBankingJpaEntity.builder()
                .id(requestedFirmBanking.getRequestedFirmBankingId())
                .fromBankName(requestedFirmBanking.getFromBankName())
                .fromBankAccountNumber(requestedFirmBanking.getFromBankAccountNumber())
                .toBankName(requestedFirmBanking.getToBankName())
                .toBankAccountNumber(requestedFirmBanking.getToBankAccountNumber())
                .moneyAmount(requestedFirmBanking.getMoneyAmount())
                .firmBankingStatus(requestedFirmBanking.getFirmBankingStatus())
                .uuid(requestedFirmBanking.getUuid())
                .build();
    }

    public RequestedFirmBanking toDomainEntity(RequestedFirmBankingJpaEntity requestedFirmBankingJpaEntity) {
        return RequestedFirmBanking.generateRequestedFirmBanking(
                RequestedFirmBanking.RequestedFirmBankingId.from(requestedFirmBankingJpaEntity.getId()),
                RequestedFirmBanking.FromBankName.from(requestedFirmBankingJpaEntity.getFromBankName()),
                RequestedFirmBanking.FromBankAccountNumber.from(requestedFirmBankingJpaEntity.getFromBankAccountNumber()),
                RequestedFirmBanking.ToBankName.from(requestedFirmBankingJpaEntity.getToBankName()),
                RequestedFirmBanking.ToBankAccountNumber.from(requestedFirmBankingJpaEntity.getToBankAccountNumber()),
                RequestedFirmBanking.MoneyAmount.from(requestedFirmBankingJpaEntity.getMoneyAmount()),
                RequestedFirmBanking.FirmBankingStatus.from(requestedFirmBankingJpaEntity.getFirmBankingStatus()),
                requestedFirmBankingJpaEntity.getUuid()
        );
    }

}
