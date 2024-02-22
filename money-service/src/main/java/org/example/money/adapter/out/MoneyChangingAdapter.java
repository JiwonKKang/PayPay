package org.example.money.adapter.out;

import com.example.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;
import org.example.money.applicaiton.port.out.ChangeMoneyPort;
import org.example.money.domain.MemberMoney;
import org.example.money.domain.MoneyChangingHistory;

import java.util.Optional;

@PersistenceAdapter
@RequiredArgsConstructor
public class MoneyChangingAdapter implements ChangeMoneyPort {

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
}
