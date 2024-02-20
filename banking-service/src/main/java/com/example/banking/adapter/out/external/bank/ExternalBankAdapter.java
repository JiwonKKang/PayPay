package com.example.banking.adapter.out.external.bank;

import com.example.banking.application.port.out.RequestBankAccountInfoPort;
import com.example.banking.application.port.out.RequestExternalFirmBankingPort;
import com.example.common.ExternalAdapter;

@ExternalAdapter
public class ExternalBankAdapter implements RequestBankAccountInfoPort, RequestExternalFirmBankingPort {

    @Override
    public BankAccount getBankAccountInfo(GetBankAccountInfoRequest request) {
        //실제로는 외부은행에 계좌정보를 요청
        return BankAccount.from(request.getBankName(), request.getBankAccountNumber(), true);
    }

    @Override
    public FirmBankingResult requestExternalFirmBanking(ExternalFirmBankingRequest request) {
        //실제로는 외부은행에 기업뱅킹을 요청
        return FirmBankingResult.from(0);
    }

}
