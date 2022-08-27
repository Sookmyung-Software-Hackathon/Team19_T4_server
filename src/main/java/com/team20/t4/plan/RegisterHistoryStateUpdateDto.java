package com.team20.t4.plan;

import com.team20.t4.member.domain.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RegisterHistoryStateUpdateDto {

    private Member applicant;
    private Plan plan;
    private State state;

    @Builder
    public RegisterHistoryStateUpdateDto(Member applicant, Plan plan, State state) {
        this.applicant = applicant;
        this.plan = plan;
        this.state = state;
    }
}
