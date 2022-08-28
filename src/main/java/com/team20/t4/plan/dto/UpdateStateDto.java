package com.team20.t4.plan.dto;

import com.team20.t4.plan.domain.State;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateStateDto {

    private State state;


    public static UpdateStateDto of(State stateEnum) {
        return UpdateStateDto.builder()
                .state(stateEnum)
                .build();
    }
}
