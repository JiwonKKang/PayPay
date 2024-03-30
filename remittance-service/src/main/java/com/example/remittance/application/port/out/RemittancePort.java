package com.example.remittance.application.port.out;

import com.example.remittance.domain.Remittance;

public interface RemittancePort {

    Remittance saveRemittance(Remittance remittance);

}
