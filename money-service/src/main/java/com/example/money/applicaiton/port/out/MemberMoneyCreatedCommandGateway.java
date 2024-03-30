package com.example.money.applicaiton.port.out;

import com.example.money.adapter.axon.command.MemberMoneyCreatedCommand;

import java.util.concurrent.CompletableFuture;

public interface MemberMoneyCreatedCommandGateway {

    CompletableFuture<Object> send(MemberMoneyCreatedCommand command);

}
