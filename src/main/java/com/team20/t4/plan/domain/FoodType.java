package com.team20.t4.plan.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum FoodType {

    KOREAN("한식"),
    JAPANESE("일식"),
    WESTERN("양식"),
    CHINESE("중식");

    @JsonValue
    private String value;

    @JsonCreator
    public static FoodType from(String value) {
        for (FoodType status : FoodType.values()) {
            if (status.getValue().equals(value)) {
                return status;
            }
        }
        return null;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
