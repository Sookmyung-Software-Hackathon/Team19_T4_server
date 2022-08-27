package com.team20.t4.member.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

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

    // update //
    public Profile updateName(String newName){
        this.name = newName;
        return this;
    }
}
