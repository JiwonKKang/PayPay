package org.example.money.applicaiton.port.in;

import org.example.money.adapter.in.ChangeMoneyRequest;
import org.example.money.adapter.in.MoneyChangingResponse;

public interface ChangeMoneyUseCase {

    MoneyChangingResponse changeMoney(ChangeMoneyCommand command);

}
