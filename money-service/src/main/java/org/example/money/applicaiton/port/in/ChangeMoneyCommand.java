package org.example.money.applicaiton.port.in;

import com.example.common.SelfValidating;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Getter;
import org.example.money.domain.MoneyChangingHistory;
import org.example.money.domain.enums.MoneyChangingStatus;
import org.example.money.domain.enums.MoneyChangingType;

@Builder
@Getter
public class ChangeMoneyCommand extends SelfValidating<ChangeMoneyCommand> {

    @NotNull
    private Long targetMembershipId;

    @NotNull
    private MoneyChangingType changingType;

    @Positive
    @NotNull
    private int changingAmount;

    @Builder
    public ChangeMoneyCommand(Long targetMembershipId, MoneyChangingType changingType, int changingAmount) {
        this.targetMembershipId = targetMembershipId;
        this.changingType = changingType;
        this.changingAmount = changingAmount;
        this.validateSelf();
    }

    public MoneyChangingHistory toDomain() {
        return MoneyChangingHistory.generateMoneyChangingHistory(
                MoneyChangingHistory.MoneyChangingId.notAssigned(),
                MoneyChangingHistory.TargetMembershipId.from(targetMembershipId),
                MoneyChangingHistory.ChangingType.from(changingType),
                MoneyChangingHistory.ChangingMoneyAmount.from(changingAmount),
                MoneyChangingHistory.ChangingStatus.from(MoneyChangingStatus.REQUESTED),
                MoneyChangingHistory.Uuid.from(java.util.UUID.randomUUID().toString())
        );
    }
}
