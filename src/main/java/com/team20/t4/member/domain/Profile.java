package com.team20.t4.member.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Entity
public class Profile {

    @Id @Column(name = "profile_pk")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "birth_year")
    private String birthYear;

    @Enumerated(EnumType.STRING)
    @Column(name = "sex")
    private Sex sex;

    private String fileKey;
    private String mbti;
    private String introduction;
    private Float score;

    @Builder
    public Profile(String birthYear, Sex sex, String mbti, String introduction, Float score) {
        this.birthYear = birthYear;
        this.sex = sex;
        this.mbti = mbti;
        this.introduction = introduction;
        this.score = Float.valueOf(0);
    }

    // update //
    public Profile updateMbti(String newMbti) {
        this.mbti = newMbti;
        return this;
    }

    public Profile updateIntroduction(String newIntroduction) {
        this.introduction = newIntroduction;
        return this;
    }
}
