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
public class ReviewResponseDtoByTarget {
    private Long reviewId;
    private Integer score;
    private String comment;
    private MemberSimpleResponseDto writer;

    public static ReviewResponseDtoByTarget of(Review review){
        return ReviewResponseDtoByTarget.builder()
                .reviewId(review.getId())
                .score(review.getScore())
                .comment(review.getComment())
                .writer(MemberSimpleResponseDto.of(review.getWriter()))
                .build();
    }
}
