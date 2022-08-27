package com.team20.t4.review;

import com.team20.t4.common.exception.RequestErrorCode;
import com.team20.t4.common.exception.RequestException;
import com.team20.t4.member.MemberService;
import com.team20.t4.member.domain.Member;
import com.team20.t4.member.domain.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final MemberService memberService;
    private final MemberRepository memberRepository;

    @Transactional
    public void saveReview(ReviewSaveRequestDto requestDto) throws RequestException {
        ReviewSaveRequestVo requestVo = getReviewSaveRequestVo(requestDto);
        reviewRepository.save(requestVo.toEntity());
    }

    private ReviewSaveRequestVo getReviewSaveRequestVo(ReviewSaveRequestDto requestDto) throws RequestException {
        ReviewSaveRequestVo requestVo = new ReviewSaveRequestVo(requestDto);
        requestVo.updateWriter(memberService.getLoginedMember());
        requestVo.updateTarget(getTarget(requestDto));
        return requestVo;
    }

    private Member getTarget(ReviewSaveRequestDto requestDto) {
        return memberRepository.findByMemberId(requestDto.getTargetId())
                .orElseThrow(() -> new RequestException(RequestErrorCode.NOT_FOUND, "회원가입하지 않은 아이디입니다."));
    }

    // 리뷰 개별 조회

    // 내가 쓴 리뷰 리스트 조회

    // 나에게 온 리뷰 리스트 조회하기

    // 평점 계산하여 Member 테이블에 반영

}
