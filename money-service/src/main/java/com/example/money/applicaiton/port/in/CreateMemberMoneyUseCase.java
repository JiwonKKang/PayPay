package com.example.money.applicaiton.port.in;

import com.example.money.adapter.axon.command.MemberMoneyCreatedCommand;

public interface CreateMemberMoneyUseCase {

    void createMemberMoney(MemberMoneyCreatedCommand command);

}
