package com.example.remittance.adapter.in;

import com.example.remittance.application.port.in.RemittanceCommand;
import com.example.remittance.application.port.in.RemittanceUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RemittanceRequestController {

    private final RemittanceUseCase remittanceUseCase;

    @PostMapping("/remittance")
    public void remittance(RemittanceRequest request) {

        RemittanceCommand command = RemittanceCommand.builder()
                .fromMembershipId(request.fromMembershipId())
                .toMembershipId(request.toMembershipId())
                .toBankAccountNumber(request.toBankAccountNumber())
                .toBankName(request.toBankName())
                .remittanceRequestType(request.remittanceRequestType())
                .moneyAmount(request.moneyAmount())
                .build();

        remittanceUseCase.remittance(command);
    }
}
