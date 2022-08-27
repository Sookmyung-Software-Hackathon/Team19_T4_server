package com.team20.t4.member.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Entity
public class Profile {

    @Id @Column(name = "member_pk")
    private Long id;

    @Column(length = 10, nullable = false, name = "member_name")
    private String name;

    @Column(name = "birth_year")
    private LocalDate birthYear;

    @Column(name = "sex")
    private Sex sex;

    private String fileKey;
    private String mbti;
    private String introduction;
    private Float score;


    @Builder
    public Profile(String name, LocalDate birthYear, Sex sex, String mbti, String introduction, Float score) {
        this.name = name;
        this.birthYear = birthYear;
        this.sex = sex;
        this.mbti = mbti;
        this.introduction = introduction;
        this.score = Float.valueOf(0);
    }

    // update //
    public Profile updateName(String newName){
        this.name = newName;
        return this;
    }
}
