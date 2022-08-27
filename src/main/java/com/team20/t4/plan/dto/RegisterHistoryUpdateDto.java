package com.team20.t4.plan.dto;

import com.team20.t4.member.domain.Member;
import com.team20.t4.plan.domain.Plan;
import com.team20.t4.plan.domain.RegisterHistory;
import com.team20.t4.plan.domain.State;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RegisterHistoryUpdateDto {

    private Member applicant;
    private Plan plan;
    private State state;

    @Builder
    public RegisterHistoryUpdateDto(Member applicant, Plan plan, State state) {
        this.applicant = applicant;
        this.plan = plan;
        this.state = state;
    }

    public RegisterHistory toEntity() {
        return RegisterHistory.builder()
                .applicant(applicant)
                .plan(plan)
                .state(state)
                .build();
    }
}
