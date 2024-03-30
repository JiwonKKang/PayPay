package com.example.remittance.adapter.out.persistence;

import com.example.remittance.domain.RemittanceRequestStatus;
import com.example.remittance.domain.RemittanceRequestType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Builder
public class RemittanceJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long remittanceId;

    private Long fromMembershipId;

    private Long toMembershipId;

    private String toBankName;

    private String toBankAccountNumber;

    private RemittanceRequestType remittanceRequestType;

    private RemittanceRequestStatus remittanceRequestStatus;

    private int moneyAmount;

}
