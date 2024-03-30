package com.example.money.adapter.axon.gateway;

import com.example.money.adapter.axon.command.DecreaseMemberMoneyCommand;
import com.example.money.adapter.axon.command.IncreaseMemberMoneyCommand;
import com.example.money.adapter.axon.command.MemberMoneyCreatedCommand;
import com.example.money.applicaiton.port.out.ChangeMemberMoneyCommandGateway;
import com.example.money.applicaiton.port.out.MemberMoneyCreatedCommandGateway;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
@RequiredArgsConstructor
public class AxonCommandCommandGateway implements MemberMoneyCreatedCommandGateway, ChangeMemberMoneyCommandGateway {

    private final CommandGateway commandGateway;

    @Override
    public CompletableFuture<Object> send(MemberMoneyCreatedCommand command) {
        return commandGateway.send(command);
    }

    @Override
    public CompletableFuture<Object> send(IncreaseMemberMoneyCommand command) {
        return commandGateway.send(command);
    }

    @Override
    public CompletableFuture<Object> send(DecreaseMemberMoneyCommand command) {
        return commandGateway.send(command);
    }
}
