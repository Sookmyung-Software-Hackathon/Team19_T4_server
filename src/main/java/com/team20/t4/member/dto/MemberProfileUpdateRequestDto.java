package com.team20.t4.member.dto;

import lombok.Getter;

import javax.validation.constraints.NotEmpty;

@Getter
public class MemberProfileUpdateRequestDto {

    @NotEmpty(message = "이름은 빈값일 수 없습니다.")
    private String name;
    private String mbti;
    private String introduction;

}
