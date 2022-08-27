package com.team20.t4.plan.dto;

import com.team20.t4.plan.domain.FoodType;
import com.team20.t4.plan.domain.Location;
import com.team20.t4.plan.domain.Plan;
import com.team20.t4.plan.domain.Progress;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class PlanUpdateRequestDto {

    private Progress progress;
    private LocalDateTime appointmentTime;
    private Location location;
    private String restaurant;
    private FoodType foodType;
    private Integer numOfParticipants;

    @Builder
    public PlanUpdateRequestDto(LocalDateTime appointmentTime,
                                Location location,
                                String restaurant,
                                FoodType foodType,
                                Integer numOfParticipants) {
        this.appointmentTime = appointmentTime;
        this.location = location;
        this.restaurant = restaurant;
        this.foodType = foodType;
        this.numOfParticipants = numOfParticipants;
    }

    public Plan toEntity()
    {
        return Plan.builder()
                .appointmentTime(appointmentTime)
                .location(location)
                .restaurant(restaurant)
                .foodType(foodType)
                .numOfParticipants(numOfParticipants)
                .build();
    }
}
