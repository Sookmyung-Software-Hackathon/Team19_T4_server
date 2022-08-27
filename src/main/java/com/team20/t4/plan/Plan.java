package com.team20.t4.plan;

import com.team20.t4.member.domain.Member;
import com.team20.t4.post.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Plan {

    @Id @Column(name = "plan_pk")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "lead_pk", nullable = false)
    private Member lead;

    @OneToOne(mappedBy = "plan")
    private Post post;

    @Column(name = "num_of_participants", nullable = false)
    @Min(1) @Max(10)
    private Integer numOfParticipants;

    @Column(name = "appointment_time", nullable = false)
    private LocalDateTime appointmentTime;

    @Column(name = "food_type", nullable = false)
    private FoodType foodType;

    @Column(name = "restaurant", nullable = false)
    private String restaurant;

    @Embedded
    @Column(name = "location", nullable = false)
    private Location location;

    @OneToMany(mappedBy = "registerHistory")
    private List<RegisterHistory> applicants = new ArrayList<>();

    @Column(name = "progress", nullable = false)
    private Progress progress;

    @Builder
    public Plan(Member lead,
                Post post,
                Integer numOfParticipants,
                LocalDateTime appointmentTime,
                FoodType foodType,
                String restaurant,
                Location location) {
        this.lead = lead;
        this.post = post;
        this.numOfParticipants = numOfParticipants;
        this.appointmentTime = appointmentTime;
        this.foodType = foodType;
        this.restaurant = restaurant;
        this.location = location;
        this.progress = Progress.RECRUITING;
    }
}
