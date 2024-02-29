package com.example.money.applicaiton.service;

import com.example.common.*;
import com.example.money.applicaiton.port.in.ChangeMoneyCommand;
import com.example.money.applicaiton.port.out.SendRechargingMoneyTaskPort;
import com.example.money.config.CountDownLatchManager;
import com.example.money.domain.MemberMoney;
import lombok.RequiredArgsConstructor;
import com.example.money.adapter.in.web.MoneyChangingResponse;
import com.example.money.applicaiton.port.in.ChangeMoneyUseCase;
import com.example.money.applicaiton.port.out.ChangeMoneyPort;
import com.example.money.domain.MoneyChangingHistory;
import com.example.money.domain.enums.MoneyChangingStatus;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@UseCase
@RequiredArgsConstructor
public class ChangeMoneyService implements ChangeMoneyUseCase {

    private final ChangeMoneyPort changeMoneyPort;
    private final SendRechargingMoneyTaskPort sendRechargingMoneyTaskPort;
    private final CountDownLatchManager countDownLatchManager;


    @Override
    @Transactional
    public MoneyChangingResponse changeMoney(ChangeMoneyCommand command) {
        String RECHARGING_MONEY_TASK = "rechargingMoneyTask";
        countDownLatchManager.addCountDownLatch(RECHARGING_MONEY_TASK);

        SubTask validateMembershipIdTask = SubTask.builder()
                .subTaskName("validateMembershipId")
                .membershipId(command.getTargetMembershipId())
                .taskType(TaskType.MEMBERSHIP)
                .status(TaskStatus.READY)
                .build();

        SubTask validateBankingTask = SubTask.builder()
                .subTaskName("validateBanking")
                .membershipId(command.getTargetMembershipId())
                .taskType(TaskType.BANKING)
                .status(TaskStatus.READY)
                .build();

        RechargingMoneyTask task = RechargingMoneyTask.builder()
                .taskId(UUID.randomUUID().toString())
                .taskName(RECHARGING_MONEY_TASK)
                .subTaskList(List.of(validateMembershipIdTask, validateBankingTask))
                .moneyAmount(command.getChangingAmount())
                .membershipId(command.getTargetMembershipId())
                .toBankName("fastcampus") // 법인 계좌 은행 이름
                .build();

        sendRechargingMoneyTaskPort.sendRechargingMoneyTask(task);

        return switch (command.getChangingType()) {
            case INCREASE -> increaseMoney(command);
            case DECREASE -> decreaseMoney(command);
        };
    }

    private MoneyChangingResponse increaseMoney(ChangeMoneyCommand command) {
        // 4. 증액을 위한 "기록". 요청 상태로 MoneyChangingRequest 를 생성한다. (MoneyChangingRequest)
        MoneyChangingHistory moneyChangingHistory = changeMoneyPort.createMoneyChangingHistory(command.toDomain());

        // 5. 펌뱅킹을 수행하고 (고객의 연동된 계좌 -> 패캠페이 법인 계좌) (뱅킹)

        // 6-1. 결과가 정상적이라면. 성공으로 MoneyChangingRequest 상태값을 변동 후에 리턴
        moneyChangingHistory.changeStatus(MoneyChangingStatus.SUCCEED);
        increaseMemberMoneyBalance(command);

        // 6-2. 결과가 비정상적이라면. 실패로 MoneyChangingRequest 상태값을 변동 후에 리턴
        // 성공 시에 멤버의 MemberMoney 값 증액이 필요
        return MoneyChangingResponse.from(moneyChangingHistory);
    }

    private void increaseMemberMoneyBalance(ChangeMoneyCommand command) {
        changeMoneyPort.getMemberMoneyByMembershipId(command.getTargetMembershipId()).ifPresentOrElse(
                memberMoney -> {
                    memberMoney.increaseBalance(command.getChangingAmount());
                    changeMoneyPort.saveMemberMoney(memberMoney);
                },
                () -> {
                    MemberMoney memberMoney = MemberMoney.generateMemberMoney(
                            MemberMoney.MemberMoneyId.notAssigned(),
                            MemberMoney.MembershipId.from(command.getTargetMembershipId()),
                            MemberMoney.Balance.from(command.getChangingAmount())
                    );
                    changeMoneyPort.saveMemberMoney(memberMoney);
                }
        );
    }


    private MoneyChangingResponse decreaseMoney(ChangeMoneyCommand command) {
        MoneyChangingHistory moneyChangingHistory = changeMoneyPort.createMoneyChangingHistory(command.toDomain());
        moneyChangingHistory.changeStatus(MoneyChangingStatus.SUCCEED);
        decreaseMemberMoneyBalance(command);
        return MoneyChangingResponse.from(moneyChangingHistory);
    }

    private void decreaseMemberMoneyBalance(ChangeMoneyCommand command) {
        changeMoneyPort.getMemberMoneyByMembershipId(command.getTargetMembershipId()).ifPresentOrElse(
                memberMoney -> {
                    memberMoney.decreaseBalance(command.getChangingAmount());
                    changeMoneyPort.saveMemberMoney(memberMoney);
                },
                () -> {
                    throw new IllegalArgumentException("잔액이 부족합니다.");
                }
        );
    }

}
