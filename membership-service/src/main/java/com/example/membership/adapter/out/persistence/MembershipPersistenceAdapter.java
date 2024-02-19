package com.example.membership.adapter.out.persistence;

import com.example.membership.application.port.out.FindMembershipPort;
import com.example.membership.application.port.out.RegisterMembershipPort;
import com.example.membership.domain.Membership;
import common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityNotFoundException;

import static com.example.membership.domain.Membership.*;

@PersistenceAdapter
@RequiredArgsConstructor
public class MembershipPersistenceAdapter implements RegisterMembershipPort, FindMembershipPort {

    private final MembershipJpaRepository membershipJpaRepository;

    @Override
    public MembershipJpaEntity createMembership(MembershipName membershipName,
                                 MembershipEmail membershipEmail,
                                 MembershipAddress membershipAddress,
                                 MembershipIsValid membershipIsValid,
                                 MembershipIsCorp membershipIsCorp) {

        return membershipJpaRepository.save(
                MembershipJpaEntity.builder()
                        .name(membershipName.getNameValue())
                        .email(membershipEmail.getEmailValue())
                        .address(membershipAddress.getAddressValue())
                        .isValid(membershipIsValid.isValidValue())
                        .isCorp(membershipIsCorp.isCorpValue())
                        .build()
        );
    }

    @Override
    public MembershipJpaEntity findMembershipById(Long membershipId) {
        return membershipJpaRepository.findById(membershipId).orElseThrow(
                () -> new EntityNotFoundException("Membership not found"));
    }
}
