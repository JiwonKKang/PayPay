package com.example.money.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MoneyChangingRepository extends JpaRepository<MoneyChangingHistoryJpaEntity, Long> {
}
