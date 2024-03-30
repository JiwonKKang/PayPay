package com.example.money.applicaiton.service;

import com.example.common.UseCase;
import com.example.money.adapter.axon.command.MemberMoneyCreatedCommand;
import com.example.money.applicaiton.port.in.CreateMemberMoneyUseCase;
import com.example.money.applicaiton.port.out.CreateMemberMonetPort;
import com.example.money.applicaiton.port.out.MemberMoneyCreatedCommandGateway;
import com.example.money.domain.MemberMoney;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@UseCase
@RequiredArgsConstructor
@Slf4j
public class CreateMemberMoneyService implements CreateMemberMoneyUseCase {

    private final MemberMoneyCreatedCommandGateway commandGateway;
    private final CreateMemberMonetPort createMemberMoneyPort;

    @Override
    public void createMemberMoney(MemberMoneyCreatedCommand command) {
        commandGateway.send(command).whenComplete((result, throwable) -> {
            if (throwable != null) {
                log.error("Error occurred while creating member money", throwable);
                throw new RuntimeException(throwable);
            }

            log.info("result - {}", result);
            MemberMoney memberMoney = MemberMoney.generateMemberMoney(
                    MemberMoney.MemberMoneyId.notAssigned(),
                    MemberMoney.MembershipId.from(command.getMembershipId()),
                    MemberMoney.AggregateIdentifier.from(result.toString()),
                    MemberMoney.Balance.from(0)
            );
            createMemberMoneyPort.createMemberMoney(memberMoney);
        });
    }
}
