package com.example.banking.application.port.out;

import com.example.banking.domain.RequestedFirmBanking;

public interface RequestFirmBankingPort {

    RequestedFirmBanking createRequestedFirmBanking(RequestedFirmBanking requestedFirmBanking);
    RequestedFirmBanking updateRequestedFirmBanking(RequestedFirmBanking requestedFirmBanking);
}
