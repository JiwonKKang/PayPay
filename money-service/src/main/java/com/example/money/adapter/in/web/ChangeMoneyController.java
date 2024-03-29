package com.example.money.adapter.in.web;

import com.example.common.WebAdapter;
import lombok.RequiredArgsConstructor;
import com.example.money.applicaiton.port.in.ChangeMoneyUseCase;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class ChangeMoneyController {

    private final ChangeMoneyUseCase changeMoneyUseCase;

    @PostMapping("/moneyChanging")
    MoneyChangingResponse changeMoney(ChangeMoneyRequest request) {
        return changeMoneyUseCase.changeMoney(request.toCommand());
    }

}
