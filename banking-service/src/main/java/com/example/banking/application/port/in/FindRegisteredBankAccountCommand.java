package com.example.banking.application.port.in;

import lombok.Data;

@Data(staticConstructor = "from")
public class FindRegisteredBankAccountCommand {

    private final Long registeredBankAccountId;

}
