package com.team20.t4.plan.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum State {

    DEFAULT("처리전"),
    PERMITTED("수락"),
    DENIED("거절");

    @JsonValue
    private String definition;

    @JsonCreator
    public static State from(String value) {
        for (State status : State.values()) {
            if (status.getDefinition().equals(value)) {
                return status;
            }
        }
        return null;
    }

    @JsonValue
    public String getDefinition() {
        return definition;
    }


}
