package com.example.money.applicaiton.port.out;

import com.example.money.adapter.axon.command.DecreaseMemberMoneyCommand;
import com.example.money.adapter.axon.command.IncreaseMemberMoneyCommand;

import java.util.concurrent.CompletableFuture;

public interface ChangeMemberMoneyCommandGateway {

    CompletableFuture<Object> send(IncreaseMemberMoneyCommand command);
    CompletableFuture<Object> send(DecreaseMemberMoneyCommand command);

}
