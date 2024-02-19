package com.example.membership.application.service;

import com.example.common.UseCase;
import com.example.membership.adapter.out.persistence.MembershipJpaEntity;
import com.example.membership.application.port.in.ModifyMembershipCommand;
import com.example.membership.application.port.in.ModifyMembershipUseCase;
import com.example.membership.application.port.out.FindMembershipPort;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
public class ModifyMembershipService implements ModifyMembershipUseCase {

    private final FindMembershipPort findMembershipPort;

    @Override
    @Transactional
    public void modifyMembership(ModifyMembershipCommand command) {
        MembershipJpaEntity membershipJpaEntity = findMembershipPort.findMembershipById(command.getId());

        membershipJpaEntity.modifyMembership(
                command.getName(),
                command.getEmail(),
                command.getAddress(),
                command.isValid(),
                command.isCorp()
        );
    }

}
