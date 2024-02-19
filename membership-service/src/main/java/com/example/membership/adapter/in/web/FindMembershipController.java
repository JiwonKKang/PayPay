package com.example.membership.adapter.in.web;

import com.example.membership.application.port.in.FindMembershipCommand;
import com.example.membership.application.port.in.FindMembershipUseCase;
import com.example.membership.domain.Membership;
import common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class FindMembershipController {

    private final FindMembershipUseCase findMembershipUseCase;

    @GetMapping("/memberships/{membershipId}")
    Membership findMembershipById(@PathVariable Long membershipId) {

        FindMembershipCommand command = FindMembershipCommand.builder()
                .id(membershipId)
                .build();

        return findMembershipUseCase.findMembershipById(command);
    }

}
