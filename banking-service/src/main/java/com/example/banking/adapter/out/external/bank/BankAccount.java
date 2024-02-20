package com.example.banking.adapter.out.external.bank;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data(staticConstructor = "from")
public class BankAccount {

        private final String bankName;
        private final String bankAccountNumber;
        private final boolean isValid;
}
