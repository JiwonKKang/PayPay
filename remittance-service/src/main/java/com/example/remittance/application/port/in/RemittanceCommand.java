package com.example.remittance.application.port.in;

import com.example.common.SelfValidating;
import com.example.remittance.domain.RemittanceRequestType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RemittanceCommand extends SelfValidating<RemittanceCommand> {

    @NotNull
    private Long fromMembershipId;

    private Long toMembershipId;

    private String toBankName;

    private String toBankAccountNumber;

    @Positive
    private int moneyAmount;

    @NotNull
    private RemittanceRequestType remittanceRequestType;

    public RemittanceCommand(Long fromMembershipId, Long toMembershipId, String toBankName, String toBankAccountNumber, int moneyAmount, RemittanceRequestType remittanceRequestType) {
        this.fromMembershipId = fromMembershipId;
        this.toMembershipId = toMembershipId;
        this.toBankName = toBankName;
        this.toBankAccountNumber = toBankAccountNumber;
        this.moneyAmount = moneyAmount;
        this.remittanceRequestType = remittanceRequestType;
        this.validateSelf();
    }


}
