package com.example.money.adapter.axon.command;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class DecreaseMemberMoneyCommand {

    @NotNull
    @TargetAggregateIdentifier
    private String aggregateIdentifier;
    @NotNull
    private final Long membershipId;
    @NotNull
    private final int amount;

    public DecreaseMemberMoneyCommand(String aggregateIdentifier, Long membershipId, int amount) {
        this.aggregateIdentifier = aggregateIdentifier;
        this.membershipId = membershipId;
        this.amount = amount;
    }

}
