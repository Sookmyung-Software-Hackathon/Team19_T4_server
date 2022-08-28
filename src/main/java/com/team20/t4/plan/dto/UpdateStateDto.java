package com.team20.t4.plan.dto;

import com.team20.t4.plan.domain.State;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UpdateStateDto {

    private State state;

    public static UpdateStateDto of(State stateEnum) {
        return UpdateStateDto.builder()
                .state(stateEnum)
                .build();
    }
}
