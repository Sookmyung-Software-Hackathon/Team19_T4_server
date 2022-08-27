package com.team20.t4.member.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.team20.t4.member.domain.Profile;
import com.team20.t4.member.domain.Sex;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ProfileSaveRequestDto {

    @NotBlank(message = "이름은 빈 값일 수 없습니다.")
    private String name;
    @NotNull(message = "출생연도는 null 값일 수 없습니다.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate birthYear;
    
    @NotNull(message = "성별은 null 값일 수 없습니다.")
    private Sex sex;
    private String mbti;
    private String introduction;
    private Float score;

    public Profile toEntity() {
        return Profile.builder()
                .name(name)
                .birthYear(birthYear)
                .sex(sex)
                .mbti(mbti)
                .introduction(introduction)
                .score((float) 0)
                .build();
    }
}
