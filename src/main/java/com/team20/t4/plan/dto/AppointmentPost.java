package com.team20.t4.plan.dto;

import com.team20.t4.plan.domain.RegisterHistory;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AppointmentPost {

    private RegisterHistory registerHistory;
    private Long postId;
}
