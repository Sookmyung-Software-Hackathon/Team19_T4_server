package com.team20.t4.plan.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.team20.t4.member.domain.Member;
import com.team20.t4.plan.domain.FoodType;
import com.team20.t4.plan.domain.Location;
import com.team20.t4.plan.domain.Plan;
import com.team20.t4.plan.domain.Progress;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class PlanSaveRequestDto {

    @Setter private Member lead;
    @Setter private Progress progress;

    @DateTimeFormat(pattern = "yyyy-MM-dd kk:mm:ss")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
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
                .lead(lead)
                .appointmentTime(appointmentTime)
                .location(location)
                .restaurant(restaurant)
                .foodType(foodType)
                .numOfParticipants(numOfParticipants)
                .build();
    }
}
