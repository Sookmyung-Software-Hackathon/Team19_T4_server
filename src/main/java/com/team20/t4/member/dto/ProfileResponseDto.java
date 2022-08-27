package com.team20.t4.member.dto;

import com.team20.t4.member.domain.Profile;
import com.team20.t4.member.domain.Sex;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class ProfileResponseDto {

    private String birthYear;
    private Sex sex;
    private String mbti;
    private String introduction;
    private Float score;

    public static ProfileResponseDto toResponseDto(Profile profile) {
        return ProfileResponseDto.builder()
                .birthYear(profile.getBirthYear())
                .sex(profile.getSex())
                .mbti(profile.getMbti())
                .introduction(profile.getIntroduction())
                .score(profile.getScore())
                .build();
    }

}
