package com.team20.t4.plan;

import com.team20.t4.common.exception.RequestErrorCode;
import com.team20.t4.common.exception.RequestException;
import com.team20.t4.member.MemberService;
import com.team20.t4.member.domain.Member;
import com.team20.t4.member.domain.MemberRepository;
import com.team20.t4.plan.domain.*;
import com.team20.t4.plan.dto.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PlanService {
    private final MemberService memberService;
    private final MemberRepository memberRepository;
    private final PlanRepository planRepository;

    private final RegisterHistoryRepository registerHistoryRepository;

    /**
     * Plan 관련 CRUD
     * */

    // 밥약 생성(포스트 생성과 동시에 자동 생성 = create Plan)
    @Transactional
    public Plan createPlan(PlanSaveRequestDto dto, Member loginedMember) {
        dto.setLead(loginedMember);
        dto.setProgress(Progress.RECRUITING);
        Plan planEntity = dto.toEntity();

        return planRepository.save(planEntity);
    }

    /**Post와 함께 Plan의 정보를 조회할 수 있는 메소드*/
    @Transactional
    public PlanInfoResponseDto readPlan(Plan plan) {
        return PlanInfoResponseDto.of(plan);
    }

    @Transactional
    public ListAppointmentSimpleResponseDto listMyPermittedAppointments() {
        Member loginedMember = memberService.getLoginedMember();
        List<AppointmentSimpleResponseDto> list = new ArrayList<>();

        for (RegisterHistory registerHistory : registerHistoryRepository.readRegisterHistoriesByPermittedMember(loginedMember)) {
            Plan plan = registerHistory.getPlan();
            Post post = plan.getPost();
            AppointmentSimpleResponseDto simpleResponseDto = new AppointmentSimpleResponseDto(post, plan);
            // TODO : Plan에 수락된 인원 구하기 - 이거 엔티티에 넣는게 나을듯
            list.add(simpleResponseDto);
        }
        ListAppointmentSimpleResponseDto responseDto = new ListAppointmentSimpleResponseDto(list);
        return responseDto;
    }

    private Integer getNoPP(Plan plan) {
        return 1;
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
    public Plan updatePlan(Long planId, PlanUpdateRequestDto dto) {
        Plan plan = planRepository.findById(planId)
                .orElseThrow(() -> new RequestException(RequestErrorCode.NOT_FOUND));

        plan.setAppointmentTime(dto.getAppointmentTime());
        plan.setLocation(dto.getLocation());
        plan.setFoodType(dto.getFoodType());
        plan.setRestaurant(dto.getRestaurant());
        return plan;
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

    public void sendAppointmentRequestOfWriter(RegisterHistorySaveRequestDto dto) {
        RegisterHistory historyEntity = RegisterHistory.builder()
                .applicant(memberService.getLoginedMember())
                .state(State.PERMITTED)
                .plan(planRepository.findById(dto.getPlanId()).get())
                .build();
        registerHistoryRepository.save(historyEntity);
    }

    // 밥약 신청(RegisterHistory 생성)
    @Transactional
    public Long sendAppointmentRequest(RegisterHistorySaveRequestDto dto) {
        RegisterHistory historyEntity = RegisterHistory.builder()
                .applicant(memberService.getLoginedMember())
                .state(State.DEFAULT)
                .plan(planRepository.findById(dto.getPlanId()).get())
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
        if (newState == State.PERMITTED) {
            Plan plan = registerHistoryEntity.getPlan();
            plan.setNumOfPermittedMember(plan.getNumOfPermittedMember()+1);
            registerHistoryEntity.setState(newState);
        }
        //TODO: 모집인원 찼는데 수락 누르면 예외 처리
        return registerHistoryEntity.getId();
    }

}
