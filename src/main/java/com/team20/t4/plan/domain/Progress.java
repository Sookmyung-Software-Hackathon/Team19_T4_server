package com.team20.t4.plan.domain;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Progress {
    RECRUITING("인원모집중"),
    FULL_MEMBER("인원모집완료"),
    COMPLETED_PLAN("밥약이행완료");

    private String definition;
}
