package com.example.membership.application.service;

import com.example.membership.adapter.out.persistence.MembershipJpaEntity;
import com.example.membership.adapter.out.persistence.MembershipMapper;
import com.example.membership.application.port.in.RegisterMembershipCommand;
import com.example.membership.application.port.in.RegisterMembershipUseCase;
import com.example.membership.application.port.out.RegisterMembershipPort;
import com.example.membership.domain.Membership;
import common.UseCase;
import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;

@UseCase
@RequiredArgsConstructor
public class RegisterMembershipService implements RegisterMembershipUseCase {

    private final RegisterMembershipPort registerMembershipPort;
    private final MembershipMapper membershipMapper;

    @Override
    @Transactional
    public Membership registerMembership(RegisterMembershipCommand command) {
        MembershipJpaEntity membershipJpaEntity = registerMembershipPort.createMembership(
                Membership.MembershipName.from(command.getName()),
                Membership.MembershipEmail.from(command.getEmail()),
                Membership.MembershipAddress.from(command.getAddress()),
                Membership.MembershipIsValid.from(command.isValid()),
                Membership.MembershipIsCorp.from(command.isCorp())
        );

        return membershipMapper.toDomainEntity(membershipJpaEntity);
    }
}
