package com.team20.t4.member.dto;

import com.team20.t4.member.domain.Profile;
import com.team20.t4.member.domain.Sex;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
@NoArgsConstructor
public class ProfileSaveRequestDto {

    @NotEmpty(message = "이름은 빈 값일 수 없습니다.")
    private String name;
    @NotEmpty(message = "출생연도는 빈 값일 수 없습니다.")
    private LocalDate birthYear;
    
    @NotEmpty(message = "성별은 빈 값일 수 없습니다.")
    private Sex sex;
    private String mbti;
    private String introduction;
    private Float score;

    public Profile toEntity() {
        return Profile.builder()
                .name(this.name)
                .birthYear(this.birthYear)
                .sex(this.sex)
                .mbti(this.mbti)
                .introduction(this.introduction)
                .score((float) 0)
                .build();
    }
}
