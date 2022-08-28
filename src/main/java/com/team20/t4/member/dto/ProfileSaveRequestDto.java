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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ProfileSaveRequestDto {

    //@NotNull(message = "출생연도는 null 값일 수 없습니다.")
    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    //@JsonDeserialize(using = LocalDateDeserializer.class)
    @NotEmpty(message = "출생연도는 빈 값일 수 없습니다.")
    @Size(min = 4, max = 4)
    private String birthYear;
    
    @NotNull(message = "성별은 null 값일 수 없습니다.")
    private Sex sex;

    private Float score;

    public Profile toEntity() {
        return Profile.builder()
                .birthYear(birthYear)
                .sex(sex)
                .score((float) 0)
                .build();
    }
}
