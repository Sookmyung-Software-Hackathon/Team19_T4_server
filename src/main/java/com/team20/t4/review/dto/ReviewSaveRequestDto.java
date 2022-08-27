package com.team20.t4.review.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewSaveRequestDto {
    @Max(value = 5, message = "5점 이하만 가능합니다.")
    @Min(value = 0, message = "0점 이상만 가능합니다.")
    private Integer score;

    @Size(max = 255, message = "comment는 255자 이하여야합니다.")
    private String comment;

    @NotBlank(message = "target의 아이디는 빈값일 수 없습니다.")
    private String targetId;
}
