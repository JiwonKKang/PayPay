package com.example.membership.application.port.out;

import com.example.membership.adapter.out.persistence.MembershipJpaEntity;

public interface FindMembershipPort {

    MembershipJpaEntity findMembershipById(Long membershipId);

}
