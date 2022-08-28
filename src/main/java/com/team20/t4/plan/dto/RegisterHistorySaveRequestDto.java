package com.team20.t4.plan.dto;

import com.team20.t4.member.domain.Member;
import com.team20.t4.plan.domain.Plan;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterHistorySaveRequestDto {

    private Long planId;

}
