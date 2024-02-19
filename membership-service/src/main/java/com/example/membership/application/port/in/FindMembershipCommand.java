package com.example.membership.application.port.in;

import com.example.common.SelfValidating;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;



@Builder
@Data
@EqualsAndHashCode(callSuper = true)
public class FindMembershipCommand extends SelfValidating<FindMembershipCommand> {

    @NotNull
    private final Long id;

    public FindMembershipCommand(Long id) {
        this.id = id;
        this.validateSelf();
    }

}
