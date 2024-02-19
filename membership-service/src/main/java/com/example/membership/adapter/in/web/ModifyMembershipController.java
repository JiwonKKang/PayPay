package com.example.membership.adapter.in.web;

import com.example.common.WebAdapter;
import com.example.membership.application.port.in.ModifyMembershipCommand;
import com.example.membership.application.port.in.ModifyMembershipUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class ModifyMembershipController {

    private final ModifyMembershipUseCase modifyMembershipUseCase;

    @PutMapping("/membership/modify")
    public void modifyMembership(@RequestBody ModifyMembershipRequest request) {
        ModifyMembershipCommand command = ModifyMembershipCommand.builder()
                .id(request.getMembershipId())
                .name(request.getName())
                .address(request.getAddress())
                .email(request.getEmail())
                .isValid(request.isValid())
                .isCorp(request.isCorp())
                .build();

        modifyMembershipUseCase.modifyMembership(command);
    }

}
