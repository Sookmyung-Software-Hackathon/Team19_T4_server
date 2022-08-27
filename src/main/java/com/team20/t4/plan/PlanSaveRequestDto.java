package com.team20.t4.plan;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.team20.t4.member.domain.Member;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@NoArgsConstructor
public class PlanSaveRequestDto {

    private Progress progress;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDateTime appointmentTime;
    private Location location;
    private String restaurant;
    private FoodType foodType;
    private Integer numOfParticipants;

    @Builder
    public PlanSaveRequestDto(Progress progress, LocalDateTime appointmentTime, Location location, String restaurant, FoodType foodType, Integer numOfParticipants) {
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
                .appointmentTime(appointmentTime)
                .location(location)
                .restaurant(restaurant)
                .foodType(foodType)
                .numOfParticipants(numOfParticipants)
                .build();
    }
}
