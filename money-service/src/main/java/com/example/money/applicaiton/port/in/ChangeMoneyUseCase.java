package com.example.money.applicaiton.port.in;

import com.example.money.adapter.in.web.MoneyChangingResponse;

public interface ChangeMoneyUseCase {

    MoneyChangingResponse changeMoney(ChangeMoneyCommand command);

}
