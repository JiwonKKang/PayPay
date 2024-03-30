package com.example.money.adapter.in.web;

import com.example.common.WebAdapter;
import com.example.money.adapter.axon.command.MemberMoneyCreatedCommand;
import com.example.money.applicaiton.port.in.ChangeMoneyCommand;
import com.example.money.applicaiton.port.in.CreateMemberMoneyUseCase;
import lombok.RequiredArgsConstructor;
import com.example.money.applicaiton.port.in.ChangeMoneyUseCase;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class ChangeMoneyController {

    private final ChangeMoneyUseCase changeMoneyUseCase;
    private final CreateMemberMoneyUseCase createMemberMoneyUseCase;

//    @PostMapping("/moneyChanging")
//    MoneyChangingResponse changeMoney(ChangeMoneyRequest request) {
//        return changeMoneyUseCase.changeMoney(request.toCommand());
//    }
    @PostMapping(path = "/money/create-member-money")
    void createMemberMoney (@RequestBody CreateMemberMoneyRequest request) {
        createMemberMoneyUseCase.createMemberMoney(
                MemberMoneyCreatedCommand.builder().membershipId(request.getMembershipId()).build());
    }

    @PostMapping(path = "/money/increase-eda")
    void increaseMoneyChangingRequestByEvent(@RequestBody ChangeMoneyRequest request) {
        ChangeMoneyCommand command = ChangeMoneyCommand.builder()
                .targetMembershipId(request.getTargetMembershipId())
                .changingType(request.getChangingType())
                .changingAmount(request.getChangingAmount())
                .build();

        changeMoneyUseCase.changeMoney(command);
    }


}
