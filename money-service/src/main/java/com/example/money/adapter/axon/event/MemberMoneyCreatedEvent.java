package com.example.money.adapter.axon.event;

import com.example.common.SelfValidating;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Builder
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class MemberMoneyCreatedEvent extends SelfValidating<MemberMoneyCreatedEvent> {

    @NotNull
    private Long membershipId;

    public MemberMoneyCreatedEvent(@NotNull Long targetMembershipId) {
        this.membershipId = targetMembershipId;
        this.validateSelf();
    }
}
