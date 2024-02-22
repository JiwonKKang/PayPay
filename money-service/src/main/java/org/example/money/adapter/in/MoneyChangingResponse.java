package org.example.money.adapter.in;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.example.money.domain.MoneyChangingHistory;
import org.example.money.domain.enums.MoneyChangingType;

@Data
@Getter
@AllArgsConstructor
public class MoneyChangingResponse {
    private Long targetMembershipId;
    private int changingAmount;
    private MoneyChangingType changingType;

    public static MoneyChangingResponse from(MoneyChangingHistory domain) {
        return new MoneyChangingResponse(
                domain.getTargetMembershipId(),
                domain.getChangingAmount(),
                domain.getChangingType()
        );
    }
}
