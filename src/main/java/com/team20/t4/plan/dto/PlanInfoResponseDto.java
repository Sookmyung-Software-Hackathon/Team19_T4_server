package com.team20.t4.plan.dto;

import com.team20.t4.plan.domain.FoodType;
import com.team20.t4.plan.domain.Location;
import com.team20.t4.plan.domain.Plan;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class PlanInfoResponseDto {

    private String leadId;
    private Integer numOfParticipants;
    private LocalDateTime appointmentTime;
    private String foodType;
    private String restaurant;
    private String location;

    @Builder
    public PlanInfoResponseDto(String leadId,
                               Integer numOfParticipants,
                               LocalDateTime appointmentTime,
                               String foodType,
                               String restaurant,
                               String location) {
        this.leadId = leadId;
        this.numOfParticipants = numOfParticipants;
        this.appointmentTime = appointmentTime;
        this.foodType = foodType;
        this.restaurant = restaurant;
        this.location = location;
    }

    public static PlanInfoResponseDto of(Plan plan) {
        return PlanInfoResponseDto.builder()
                .leadId(plan.getLead().getMemberId())
                .numOfParticipants(plan.getNumOfParticipants())
                .appointmentTime(plan.getAppointmentTime())
                .foodType(plan.getFoodType().getValue())
                .restaurant(plan.getRestaurant())
                .location(plan.getLocation().getGu().getValue())
                .build();

    }
}
