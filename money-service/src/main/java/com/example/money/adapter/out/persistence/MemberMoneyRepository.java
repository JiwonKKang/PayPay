package com.example.money.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MemberMoneyRepository extends JpaRepository<MemberMoneyJpaEntity, Long> {

    @Query("""
            SELECT m FROM MemberMoneyJpaEntity m
            WHERE m.membershipId = :membershipId
            ORDER BY m.id DESC
            LIMIT 1
            """)
    Optional<MemberMoneyJpaEntity> findByMembershipId(Long membershipId);

}
