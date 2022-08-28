package com.team20.t4.member.dto;

import com.team20.t4.review.dto.ReviewResponseDtoByTarget;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberInfoAndReviewListResponseDto {
    private List<ReviewResponseDtoByTarget> reviewListOfOther;
    private MemberInfoResponseDto memberInfoResponseDto;
}
