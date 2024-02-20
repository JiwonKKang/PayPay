package com.example.banking.adapter.out.external.bank;

import lombok.Data;

@Data(staticConstructor = "from")
public class FirmBankingResult {

    private final int resultCode; // 0 : 성공, 1 : 실패

    public boolean isFailed() {
        return resultCode == 1;
    }

}
