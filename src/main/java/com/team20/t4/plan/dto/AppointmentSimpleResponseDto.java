package com.team20.t4.plan.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.team20.t4.plan.domain.FoodType;
import com.team20.t4.plan.domain.Plan;
import com.team20.t4.plan.domain.RegisterHistory;
import com.team20.t4.post.domain.Post;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentSimpleResponseDto {
    private Long postId;
    private String postTitle;
    private LocalDateTime appointmentTime;
    private String restaurant;
    private Integer numOfParticipants;
    @Setter private Integer numOfPermittedMember;


    public AppointmentSimpleResponseDto(Post post, Plan plan){
        this.postId = post.getId();
        this.postTitle = post.getTitle();
        this.appointmentTime = plan.getAppointmentTime();
        this.restaurant = plan.getRestaurant();
        this.numOfParticipants = plan.getNumOfParticipants();
        this.numOfPermittedMember = plan.getNumOfPermittedMember();
    }


}
