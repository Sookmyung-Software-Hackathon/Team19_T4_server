package com.team20.t4.plan;


import com.team20.t4.member.domain.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class PlanInfoResponseDto {

    private Member lead;
    private Integer numOfParticipants;
    private LocalDateTime appointmentTime;
    private FoodType foodType;
    private String restaurant;
    private Location location;

    @Builder
    public PlanInfoResponseDto(Member lead,
                               Integer numOfParticipants,
                               LocalDateTime appointmentTime,
                               FoodType foodType,
                               String restaurant,
                               Location location) {
        this.lead = lead;
        this.numOfParticipants = numOfParticipants;
        this.appointmentTime = appointmentTime;
        this.foodType = foodType;
        this.restaurant = restaurant;
        this.location = location;
    }

    public static PlanInfoResponseDto of(Plan plan) {
        return PlanInfoResponseDto.builder()
                .lead(plan.getLead())
                .numOfParticipants(plan.getNumOfParticipants())
                .appointmentTime(plan.getAppointmentTime())
                .foodType(plan.getFoodType())
                .restaurant(plan.getRestaurant())
                .location(plan.getLocation())
                .build();

    }
}