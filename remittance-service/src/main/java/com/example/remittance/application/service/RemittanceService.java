package com.example.remittance.application.service;

import com.example.common.UseCase;
import com.example.remittance.application.port.in.RemittanceCommand;
import com.example.remittance.application.port.in.RemittanceUseCase;

@UseCase
public class RemittanceService implements RemittanceUseCase {

        @Override
        public void remittance(RemittanceCommand command) {

        }
}
