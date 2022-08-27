package com.team20.t4.review.dto;

import com.team20.t4.common.exception.RequestException;
import com.team20.t4.member.domain.Member;
import com.team20.t4.review.Review;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewSaveRequestVo {
    private Integer score;
    private String comment;
    private Member target;
    private Member writer;

    public ReviewSaveRequestVo(ReviewSaveRequestDto requestDto){
        this.score = requestDto.getScore();
        this.comment = requestDto.getComment();
    }

    public static ReviewSaveRequestVo of(ReviewSaveRequestDto requestDto) throws RequestException {
        return ReviewSaveRequestVo.builder()
                .comment(requestDto.getComment())
                .score(requestDto.getScore())
                .build();
    }

    public void updateTarget(Member target){
        this.target = target;
    }

    public void updateWriter(Member loginedMember){
        this.writer = loginedMember;
    }

    public Review toEntity() {
        return Review.builder()
                .score(score)
                .comment(comment)
                .target(target)
                .writer(writer)
                .build();
    }
}
