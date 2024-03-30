package com.example.money.adapter.out.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class MemberMoneyJpaEntity {

    @Id
    @GeneratedValue
    private Long id;

    private Long membershipId;

    private int balance;

    private String aggregateIdentifier;

    @Builder
    public MemberMoneyJpaEntity(Long membershipId, int balance, String aggregateIdentifier) {
        this.membershipId = membershipId;
        this.balance = balance;
        this.aggregateIdentifier = aggregateIdentifier;
    }

}
