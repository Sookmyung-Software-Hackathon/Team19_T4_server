package com.team20.t4.plan;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PlanController {

    private final PlanService planService;

    @PostMapping("/plan/new")
    public Long createPlan(@RequestBody PlanSaveRequestDto saveRequestDto) {
        return planService.createPlan(saveRequestDto);
    }


    @PostMapping("/plan/time/{planId}")
    public Long updateAppointmentTime(@PathVariable Long planId, @RequestBody AppointmentTimeVO newAppointmentTime) {
        return planService.updateAppointmentTime(planId, newAppointmentTime.getAppointmentTime());
    }

    /**아래 메소드 지우고 Post 수정할 때 PlanService.updatePlan() 같이 호출해도 됨*/
    @PostMapping("/plan/{planId}")
    public Long updatePlan(@PathVariable Long planId, @RequestBody PlanUpdateRequestDto dto) {
        return planService.updatePlan(planId, dto);
    }

    @PostMapping("/plan/progress/{planId}")
    public Long updateProgress(@PathVariable Long planId, @RequestBody Progress progress) {
        return planService.updateProgressState(planId, progress);
    }

    @PostMapping("/registerHistory/new")
    public Long sendAppointmentRequest(@RequestBody RegisterHistorySaveRequestDto dto) {
        return planService.sendAppointmentRequest(dto);
    }

    @PostMapping("/registerHistory/state/{registerHistoryId}")
    public Long updateState(@PathVariable Long registerHistoryId, @RequestBody State state) {
        return planService.response(registerHistoryId, state);
    }
}
