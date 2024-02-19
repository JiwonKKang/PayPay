package com.example.membership.application.port.in;

import common.SelfValidating;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;


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
