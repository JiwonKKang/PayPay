package com.example.money.adapter.in.web;

import com.example.money.domain.MoneyChangingHistory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import com.example.money.domain.enums.MoneyChangingType;

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
