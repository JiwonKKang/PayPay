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

    @Builder
    public MemberMoneyJpaEntity(Long id, Long membershipId, int balance) {
        this.id = id;
        this.membershipId = membershipId;
        this.balance = balance;
    }

}
