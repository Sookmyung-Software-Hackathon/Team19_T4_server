package com.team20.t4.review;

import com.team20.t4.common.responseFormat.OnlyResponseString;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping("/review")
    public OnlyResponseString saveReview(@RequestBody @Valid ReviewSaveRequestDto requestDto){
        reviewService.saveReview(requestDto);
        return new OnlyResponseString("후기를 작성했습니다.");
    }

}
