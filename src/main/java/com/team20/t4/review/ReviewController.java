package com.team20.t4.review;

import com.team20.t4.common.responseFormat.OnlyResponseString;
import com.team20.t4.review.dto.ReviewResponseDto;
import com.team20.t4.review.dto.ReviewSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping("/review")
    public OnlyResponseString saveReview(@RequestBody @Valid ReviewSaveRequestDto requestDto){
        reviewService.saveReview(requestDto);
        return new OnlyResponseString("후기를 작성했습니다.");
    }

    @GetMapping("/review/{reviewId}")
    public ReviewResponseDto getSingleReview(@PathVariable Long reviewId){
        return reviewService.getReview(reviewId);
    }

    @GetMapping("/review/writer")
    public List<ReviewResponseDto> getReviewListWrittenByMe(){
        return reviewService.getReviewList();
    }

}
