package com.team20.t4.review;

import com.team20.t4.common.entity.BaseTimeEntity;
import com.team20.t4.member.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Review extends BaseTimeEntity {

    @Id @Column(name = "review_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "review_score")
    private Float score;

    @Column(name = "review_comment")
    private String comment;

    @OneToOne
    private Member writer;

    @OneToOne
    private Member target;

}

