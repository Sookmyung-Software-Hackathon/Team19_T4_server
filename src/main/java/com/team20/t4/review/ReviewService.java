package com.team20.t4.review;

import com.team20.t4.common.exception.RequestErrorCode;
import com.team20.t4.common.exception.RequestException;
import com.team20.t4.member.MemberService;
import com.team20.t4.member.domain.Member;
import com.team20.t4.member.domain.MemberRepository;
import com.team20.t4.review.dto.ReviewResponseDto;
import com.team20.t4.review.dto.ReviewSaveRequestDto;
import com.team20.t4.review.dto.ReviewSaveRequestVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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

    @Transactional
    public ReviewResponseDto getReview(Long reviewId) throws RequestException {
        Review review = getSingleReview(reviewId);
        return ReviewResponseDto.of(review);
    }

    private Review getSingleReview(Long reviewId) {
        return reviewRepository.findById(reviewId)
                .orElseThrow(() -> new RequestException(RequestErrorCode.NOT_FOUND, "존재하지 않는 후기입니다."));
    }

    @Transactional
    public List<ReviewResponseDto> getReviewList(){
        Member loginedMember = memberService.getLoginedMember();
        List<Review> reviewList = reviewRepository.findAllByWriter(loginedMember);
        return reviewList.stream().map(
                review -> ReviewResponseDto.of(review)
        ).collect(Collectors.toList());
    }

    // 나에게 온 리뷰 리스트 조회하기

    // 평점 계산하여 Member 테이블에 반영

}
