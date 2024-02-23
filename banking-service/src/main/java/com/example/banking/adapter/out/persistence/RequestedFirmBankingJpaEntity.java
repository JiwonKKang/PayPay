package com.example.banking.adapter.out.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class RequestedFirmBankingJpaEntity {

    @Id
    @GeneratedValue
    @Column(name = "requested_firm_banking_id")
    private Long id;

    private String fromBankName;

    private String fromBankAccountNumber;

    private String toBankName;

    private String toBankAccountNumber;

    private Long moneyAmount;

    private int firmBankingStatus;

    private String uuid;

    @Builder
    public RequestedFirmBankingJpaEntity(Long id,
                                         String fromBankName,
                                         String fromBankAccountNumber,
                                         String toBankName,
                                         String toBankAccountNumber,
                                         Long moneyAmount,
                                         int firmBankingStatus,
                                         String uuid) {
        this.id = id;
        this.fromBankName = fromBankName;
        this.fromBankAccountNumber = fromBankAccountNumber;
        this.toBankName = toBankName;
        this.toBankAccountNumber = toBankAccountNumber;
        this.moneyAmount = moneyAmount;
        this.firmBankingStatus = firmBankingStatus;
        this.uuid = uuid;
    }
}
