package com.example.banking.adapter.in.web;

import com.example.banking.application.port.in.RequestFirmBankingUseCase;
import com.example.banking.application.port.in.RequestedFirmBankingResponse;
import com.example.common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class RequestFirmBankingController {

    private final RequestFirmBankingUseCase requestFirmBankingUseCase;

    @PostMapping("/firm-banking")
    public RequestedFirmBankingResponse requestFirmBanking(@RequestBody RequestFirmBankingRequest request) {
        return requestFirmBankingUseCase.requestFirmBanking(request.toCommand());
    }

}
