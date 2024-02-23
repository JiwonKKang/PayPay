package com.example.money.adapter.in.web;

import com.example.money.applicaiton.port.in.ChangeMoneyCommand;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.money.domain.enums.MoneyChangingType;

@Data
@NoArgsConstructor
public class ChangeMoneyRequest {

    private Long targetMembershipId;
    private MoneyChangingType changingType;
    private int changingAmount;

    public ChangeMoneyCommand toCommand() {
        return ChangeMoneyCommand.builder()
                .targetMembershipId(targetMembershipId)
                .changingType(changingType)
                .changingAmount(changingAmount)
                .build();
    }

}
