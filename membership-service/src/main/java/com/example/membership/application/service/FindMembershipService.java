package com.example.membership.application.service;

import com.example.membership.adapter.out.persistence.MembershipJpaEntity;
import com.example.membership.adapter.out.persistence.MembershipMapper;
import com.example.membership.application.port.in.FindMembershipCommand;
import com.example.membership.application.port.in.FindMembershipUseCase;
import com.example.membership.application.port.out.FindMembershipPort;
import com.example.membership.domain.Membership;
import common.UseCase;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class FindMembershipService implements FindMembershipUseCase {

    private final FindMembershipPort findMembershipPort;
    private final MembershipMapper membershipMapper;

    @Override
    public Membership findMembershipById(FindMembershipCommand command) {
        MembershipJpaEntity membershipJpaEntity = findMembershipPort.findMembershipById(command.getId());

        return membershipMapper.toDomainEntity(membershipJpaEntity);
    }
}
