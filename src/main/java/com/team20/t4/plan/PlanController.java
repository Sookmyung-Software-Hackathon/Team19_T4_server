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
<<<<<<< HEAD
    public Long updateProgress(@PathVariable Long planId, @RequestBody UpdateProgressDto progress) {
=======
    public Long updateProgress(@PathVariable Long planId, @RequestBody ProgressUpdateDto progress) {
>>>>>>> 2ace5f0fbd8a28baa9d6ac7f06a870029caa93b9
        return planService.updateProgressState(planId, progress.getProgress());
    }

    @PostMapping("/registerHistory/new")
    public Long sendAppointmentRequest(@RequestBody RegisterHistorySaveRequestDto dto) {
        return planService.sendAppointmentRequest(dto);
    }

    @PostMapping("/registerHistory/state/{registerHistoryId}")
<<<<<<< HEAD
    public Long updateState(@PathVariable Long registerHistoryId, @RequestBody UpdateStateDto state) {
=======
    public Long updateState(@PathVariable Long registerHistoryId, @RequestBody StateUpdateDto state) {
>>>>>>> 2ace5f0fbd8a28baa9d6ac7f06a870029caa93b9
        return planService.response(registerHistoryId, state.getState());
    }
}
