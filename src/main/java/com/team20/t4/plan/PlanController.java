package com.team20.t4.plan;

import com.team20.t4.plan.domain.Progress;
import com.team20.t4.plan.domain.ProgressUpdateDto;
import com.team20.t4.plan.domain.State;
import com.team20.t4.plan.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PlanController {

    private final PlanService planService;

    @GetMapping("/plan/permitted/list")
    public ListAppointmentSimpleResponseDto listMemberAppointments() {
        return planService.listMyPermittedAppointments();
    }


    @PostMapping("/plan/time/{planId}")
    public Long updateAppointmentTime(@PathVariable Long planId, @RequestBody AppointmentTimeVO newAppointmentTime) {
        return planService.updateAppointmentTime(planId, newAppointmentTime.getAppointmentTime());
    }

    /**아래 메소드 지우고 Post 수정할 때 PlanService.updatePlan() 같이 호출해도 됨*/
    @PostMapping("/plan/{planId}")
    public Long updatePlan(@PathVariable Long planId, @RequestBody PlanUpdateRequestDto dto) {
        return planService.updatePlan(planId, dto).getId();
    }

    @PostMapping("/plan/progress/{planId}")
    public Long updateProgress(@PathVariable Long planId, @RequestBody ProgressUpdateDto progress) {
        return planService.updateProgressState(planId, progress.getProgress());
    }

    @PostMapping("/registerHistory/new")
    public Long sendAppointmentRequest(@RequestBody RegisterHistorySaveRequestDto dto) {
        return planService.sendAppointmentRequest(dto);
    }

    @PostMapping("/registerHistory/state/{registerHistoryId}")
    public Long updateState(@PathVariable Long registerHistoryId, @RequestBody StateUpdateDto state) {
        return planService.response(registerHistoryId, state.getState());
    }
}
