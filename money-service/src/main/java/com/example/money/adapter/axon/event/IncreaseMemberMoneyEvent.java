package com.example.money.adapter.axon.event;

import com.example.common.SelfValidating;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Builder
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class IncreaseMemberMoneyEvent extends SelfValidating<IncreaseMemberMoneyEvent> {
    private  String aggregateIdentifier;
    private  Long targetMembershipId;
    private  int amount;

    public IncreaseMemberMoneyEvent(String aggregateIdentifier, Long targetMembershipId, int amount) {
        this.aggregateIdentifier = aggregateIdentifier;
        this.targetMembershipId = targetMembershipId;
        this.amount = amount;
    }

}
