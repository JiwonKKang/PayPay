package com.example.membership.adapter.out.persistence;


import com.example.membership.domain.Membership;
import org.springframework.stereotype.Component;

@Component
public class MembershipMapper {

    public Membership toDomainEntity(MembershipJpaEntity membershipJpaEntity) {
        return Membership.generateMember(
                Membership.MembershipId.from(membershipJpaEntity.getMembershipId().toString()),
                Membership.MembershipName.from(membershipJpaEntity.getName()),
                Membership.MembershipEmail.from(membershipJpaEntity.getEmail()),
                Membership.MembershipAddress.from(membershipJpaEntity.getAddress()),
                Membership.MembershipIsValid.from(membershipJpaEntity.isValid()),
                Membership.MembershipIsCorp.from(membershipJpaEntity.isCorp())
        );
    }

}
