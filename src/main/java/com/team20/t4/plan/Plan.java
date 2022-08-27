package com.team20.t4.plan;

import com.team20.t4.member.domain.Member;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Plan {

    @Id @Column(name = "plan_pk")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "lead_pk")
    private Member lead;

    //private Post post;

    @Column(name = "appointment_time")
    private LocalDateTime appointmentTime;

    private State state;
    private FoodType foodType;

    @Embedded
    @Column(name = "location")
    private Location location;
}
