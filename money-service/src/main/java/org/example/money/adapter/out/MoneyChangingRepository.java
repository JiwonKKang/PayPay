package org.example.money.adapter.out;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MoneyChangingRepository extends JpaRepository<MoneyChangingHistoryJpaEntity, Long> {
}
