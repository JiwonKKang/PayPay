package com.example.money.adapter.out.persistence;

import com.example.common.PersistenceAdapter;
import com.example.money.applicaiton.port.out.ChangeMoneyPort;
import com.example.money.applicaiton.port.out.CreateMemberMonetPort;
import com.example.money.domain.MemberMoney;
import com.example.money.domain.MoneyChangingHistory;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@PersistenceAdapter
@RequiredArgsConstructor
public class MoneyChangingAdapter implements ChangeMoneyPort, CreateMemberMonetPort {

    private final MoneyChangingRepository moneyChangingRepository;
    private final MoneyChangingHistoryMapper moneyChangingMapper;
    private final MemberMoneyRepository memberMoneyRepository;
    private final MemberMoneyMapper memberMoneyMapper;

    @Override
    public MoneyChangingHistory createMoneyChangingHistory(MoneyChangingHistory moneyChanging) {
        MoneyChangingHistoryJpaEntity jpaEntity = moneyChangingMapper.toJpaEntity(moneyChanging);
        return moneyChangingMapper.toDomain(moneyChangingRepository.save(jpaEntity));
    }

    @Override
    public Optional<MemberMoney> getMemberMoneyByMembershipId(Long membershipId) {
        return memberMoneyRepository.findByMembershipId(membershipId)
                .map(memberMoneyMapper::toDomain);
    }

    @Override
    public void saveMemberMoney(MemberMoney memberMoney) {
        memberMoneyRepository.save(memberMoneyMapper.toJpaEntity(memberMoney));
    }

    @Override
    public void createMemberMoney(MemberMoney memberMoney) {
        memberMoneyRepository.save(memberMoneyMapper.toJpaEntity(memberMoney));
    }
}
