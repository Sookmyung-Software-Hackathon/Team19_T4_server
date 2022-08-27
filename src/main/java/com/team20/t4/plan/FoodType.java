package com.team20.t4.plan;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FoodType {

    KOREAN("한식"),
    JAPANESE("일식"),
    WESTERN("양식"),
    CHINESE("중식");


    private String value;
}
