package com.example.membership.application.port.in;


import com.example.common.SelfValidating;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;


@Getter
public class ModifyMembershipCommand extends SelfValidating<ModifyMembershipCommand> {

    private final Long id;

    @NotNull
    private final String name;

    private final String email;

    private final String address;

    @AssertTrue
    private final boolean isValid;

    private final boolean isCorp;

    @Builder
    public ModifyMembershipCommand(Long id, String name, String email, String address, boolean isValid, boolean isCorp) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.isValid = isValid;
        this.isCorp = isCorp;
        this.validateSelf();
    }
}
