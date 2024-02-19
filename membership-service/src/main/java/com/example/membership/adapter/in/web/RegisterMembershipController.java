package com.example.membership.adapter.in.web;

import com.example.common.WebAdapter;
import com.example.membership.application.port.in.RegisterMembershipCommand;
import com.example.membership.application.port.in.RegisterMembershipUseCase;
import com.example.membership.domain.Membership;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class  RegisterMembershipController {

    private final RegisterMembershipUseCase registerMembershipUseCase;

    @PostMapping("/membership/register")
    public Membership registerMembership(@RequestBody RegisterMembershipRequest request) {
        RegisterMembershipCommand command = RegisterMembershipCommand.builder()
                .name(request.getName())
                .address(request.getAddress())
                .email(request.getEmail())
                .isValid(true)
                .isCorp(request.isCorp())
                .build();

        return registerMembershipUseCase.registerMembership(command);
    }
}
