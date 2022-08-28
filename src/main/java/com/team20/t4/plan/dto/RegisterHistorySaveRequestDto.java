package com.team20.t4.plan.dto;

import com.team20.t4.member.domain.Member;
import com.team20.t4.plan.domain.Plan;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RegisterHistorySaveRequestDto {

    private Long applicantId;
    private Long planId;

}
