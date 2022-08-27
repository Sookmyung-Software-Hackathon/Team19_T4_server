package com.team20.t4.review.dto;

import com.team20.t4.member.dto.MemberSimpleResponseDto;
import com.team20.t4.review.Review;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class ReviewResponseDto {
    private Integer score;
    private String comment;
    private MemberSimpleResponseDto target;

    public static ReviewResponseDto of(Review review){
        return ReviewResponseDto.builder()
                .score(review.getScore())
                .comment(review.getComment())
                .target(MemberSimpleResponseDto.of(review.getTarget()))
                .build();
    }

}
