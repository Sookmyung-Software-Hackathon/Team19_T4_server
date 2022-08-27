package com.team20.t4.plan.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum State {

    DEFAULT("처리전"),
    PERMITTED("수락"),
    DENIED("거절");

    private String definition;
}
