package com.team20.t4.plan;

import com.team20.t4.member.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RegisterHistorySaveRequestDto {

    private Member applicant;
    private Plan plan;

}
