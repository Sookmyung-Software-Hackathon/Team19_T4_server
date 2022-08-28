package com.team20.t4.plan.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Progress {
    RECRUITING("인원모집중"),
    FULL_MEMBER("인원모집완료"),
    COMPLETED_PLAN("밥약이행완료");

    @JsonValue
    private String definition;

    @JsonCreator
    public static Progress from(String value) {
        for (Progress status : Progress.values()) {
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
