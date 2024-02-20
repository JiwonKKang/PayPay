package com.example.banking.application.port.in;

import com.example.banking.domain.RequestedFirmBanking;
import com.example.common.SelfValidating;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class RequestedFirmBankingCommand extends SelfValidating<RequestedFirmBankingCommand> {

    @NotNull
    private final String fromBankName;

    @NotNull
    private final String fromBankAccountNumber;

    @NotNull
    private final String toBankName;

    @NotNull
    private final String toBankAccountNumber;

    @NotNull
    private final Long moneyAmount;

    @Builder
    public RequestedFirmBankingCommand(String fromBankName, String fromBankAccountNumber, String toBankName, String toBankAccountNumber, Long moneyAmount) {
        this.fromBankName = fromBankName;
        this.fromBankAccountNumber = fromBankAccountNumber;
        this.toBankName = toBankName;
        this.toBankAccountNumber = toBankAccountNumber;
        this.moneyAmount = moneyAmount;
        this.validateSelf();
    }

    public RequestedFirmBanking toDomain() {
        return RequestedFirmBanking.generateRequestedFirmBanking(
                RequestedFirmBanking.RequestedFirmBankingId.notAssigned(),
                RequestedFirmBanking.FromBankName.from(this.fromBankName),
                RequestedFirmBanking.FromBankAccountNumber.from(this.fromBankAccountNumber),
                RequestedFirmBanking.ToBankName.from(this.toBankName),
                RequestedFirmBanking.ToBankAccountNumber.from(this.toBankAccountNumber),
                RequestedFirmBanking.MoneyAmount.from(this.moneyAmount),
                RequestedFirmBanking.FirmBankingStatus.from(0),
                UUID.randomUUID()
        );
    }

}
