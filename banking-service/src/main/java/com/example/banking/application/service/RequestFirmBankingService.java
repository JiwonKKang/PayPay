package com.example.banking.application.service;


import com.example.banking.adapter.out.external.bank.FirmBankingResult;
import com.example.banking.application.port.in.RequestFirmBankingUseCase;
import com.example.banking.application.port.in.RequestedFirmBankingCommand;
import com.example.banking.application.port.in.RequestedFirmBankingResponse;
import com.example.banking.application.port.out.RequestExternalFirmBankingPort;
import com.example.banking.application.port.out.RequestFirmBankingPort;
import com.example.banking.domain.RequestedFirmBanking;
import com.example.common.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
public class RequestFirmBankingService implements RequestFirmBankingUseCase {

    private final RequestFirmBankingPort requestFirmBankingPort;
    private final RequestExternalFirmBankingPort requestExternalFirmBankingPort;


    @Override
    @Transactional
    public RequestedFirmBankingResponse requestFirmBanking(RequestedFirmBankingCommand command) {

        RequestedFirmBanking requestedFirmBanking =
                requestFirmBankingPort.createRequestedFirmBanking(command.toDomain());

        FirmBankingResult firmBankingResult =
                requestExternalFirmBankingPort.requestExternalFirmBanking(requestedFirmBanking.toExternalFirmBankingRequest());


        if (firmBankingResult.isSuccess()) {
            requestedFirmBanking.updateStatusToComplete();
        } else {
            requestedFirmBanking.updateStatusToFail();
        }

        requestFirmBankingPort.updateRequestedFirmBanking(requestedFirmBanking);
        return RequestedFirmBankingResponse.from(requestedFirmBanking);
    }

}
