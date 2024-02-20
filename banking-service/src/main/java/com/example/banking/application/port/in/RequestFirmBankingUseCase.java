package com.example.banking.application.port.in;

public interface RequestFirmBankingUseCase {
    RequestedFirmBankingResponse requestFirmBanking(RequestedFirmBankingCommand command);

}
