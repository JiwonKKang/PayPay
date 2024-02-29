package com.example.banking.adapter.out.service;

import com.example.banking.application.port.out.GetMembershipPort;
import com.example.banking.application.port.out.Membership;
import com.example.common.ExternalAdapter;

@ExternalAdapter
public class MembershipServiceAdapter implements GetMembershipPort {

    @Override
    public Membership getMembership(Long membershipId) {
        return null;
    }
}
