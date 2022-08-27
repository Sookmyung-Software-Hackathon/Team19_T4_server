package com.team20.t4.plan;

import com.team20.t4.member.domain.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class RegisterHistory {

    @Id @Column(name = "register_history_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_pk")
    private Member applicant;

    @ManyToOne
    @JoinColumn(name = "plan_pk")
    private Plan plan;

    @Column(name = "state", nullable = false)
    @Setter
    private State state;

    @Builder
    public RegisterHistory(Member applicant, Plan plan, State state) {
        this.applicant = applicant;
        this.plan = plan;
        this.state = state;
    }
}
