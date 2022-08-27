package com.team20.t4.plan;

import com.team20.t4.member.domain.Member;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
public class PlanSaveRequestDto {

    private Member lead;
    private Progress progress;
    private LocalDateTime appointmentTime;
    private Location location;
    private String restaurant;
    private FoodType foodType;
    private Integer numOfParticipants;

    @Builder
    public PlanSaveRequestDto(Member lead, Progress progress, LocalDateTime appointmentTime, Location location, String restaurant, FoodType foodType, Integer numOfParticipants) {
        this.lead = lead;
        this.progress = progress;
        this.appointmentTime = appointmentTime;
        this.location = location;
        this.restaurant = restaurant;
        this.foodType = foodType;
        this.numOfParticipants = numOfParticipants;
    }

    public Plan toEntity()
    {
        return Plan.builder()
                .lead(lead)
                .appointmentTime(appointmentTime)
                .location(location)
                .restaurant(restaurant)
                .foodType(foodType)
                .numOfParticipants(numOfParticipants)
                .build();
    }
}
