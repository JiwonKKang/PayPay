package org.example.money.adapter.in;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.money.applicaiton.port.in.ChangeMoneyCommand;
import org.example.money.domain.enums.MoneyChangingType;

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
