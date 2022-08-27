package com.team20.t4.plan;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class PlanService {

    private final PlanRepository planRepository;

    private final RegisterHistoryRepository registerHistoryRepository;

    // 밥약 생성(포스트 생성과 동시에 자동 생성 Plan 생성)
    @Transactional
    public Long createPlan(PlanSaveRequestDto dto) {
        Plan planEntity = dto.toEntity();
        planRepository.save(planEntity);
        return planEntity.getId();
    }

    // 밥약 시간 수정(Plan 수정)
    // 밥약 장소, 시간, 음식종류, 음식점 수정 (Plan 수정)
    // 밥약 진행 상태 수정 (Plan 수정)
    // 밥약 신청(RegisterHistory 생성)
    @Transactional
    public Long sendAppointmentRequest(RegisterHistorySaveRequestDto dto) {
        RegisterHistory historyEntity = RegisterHistory.builder()
                .applicant(dto.getApplicant())
                .state(State.DEFAULT)
                .plan(dto.getPlan())
                .build();
        registerHistoryRepository.save(historyEntity);
        return historyEntity.getId();
    }
    // 밥약 수락/거절(RegisterHistory 수정)
    @Transactional
    public Long response(RegisterHistoryStateUpdateDto dto, State newState) {
        RegisterHistory registerHistoryEntity = RegisterHistory.builder()
                .applicant(dto.getApplicant())
                .plan(dto.getPlan())
                .state(newState)
                .build();
        registerHistoryRepository.save(registerHistoryEntity);
        return registerHistoryEntity.getId();
    }

}
