package com.team20.t4.plan;

import com.team20.t4.common.exception.RequestErrorCode;
import com.team20.t4.common.exception.RequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PlanService {

    private final PlanRepository planRepository;

    private final RegisterHistoryRepository registerHistoryRepository;

    /**
     * Plan 관련 CRUD
     * */

    // 밥약 생성(포스트 생성과 동시에 자동 생성 = create Plan)
    @Transactional
    public Long createPlan(PlanSaveRequestDto dto) {
        Plan planEntity = dto.toEntity();
        planRepository.save(planEntity);
        return planEntity.getId();
    }

    // 밥약 시간 수정(Plan 수정)
    @Transactional
    public Long updateAppointmentTime(Long planId, LocalDateTime newTime) {
        Plan plan = planRepository.findById(planId)
                .orElseThrow(() -> new RequestException(RequestErrorCode.NOT_FOUND));
        plan.setAppointmentTime(newTime);
        return plan.getId();
    }

    // 밥약 장소, 시간, 음식종류, 음식점 수정 (Plan 수정)
    @Transactional
    public Long updatePlan(Long planId, PlanUpdateRequestDto dto) {
        Plan plan = planRepository.findById(planId)
                .orElseThrow(() -> new RequestException(RequestErrorCode.NOT_FOUND));

        plan.setAppointmentTime(dto.getAppointmentTime());
        plan.setLocation(dto.getLocation());
        plan.setFoodType(dto.getFoodType());
        plan.setRestaurant(dto.getRestaurant());
        return plan.getId();
    }

    // 밥약 진행 상태 수정 (Plan 수정)
    @Transactional
    public Long updateProgressState(Long planId, Progress newProgress) {
        Plan plan = planRepository.findById(planId)
                .orElseThrow(() -> new RequestException(RequestErrorCode.NOT_FOUND));

        plan.setProgress(newProgress);
        return planId;
    }

    /**
     * RegisterHistory 관련 CRUD
     * */

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
    public Long response(Long registerHistoryId, State newState) {
        RegisterHistory registerHistoryEntity = registerHistoryRepository.findById(registerHistoryId)
                .orElseThrow(() -> new RequestException(RequestErrorCode.NOT_FOUND));
        registerHistoryEntity.setState(newState);
        return registerHistoryEntity.getId();
    }

}
