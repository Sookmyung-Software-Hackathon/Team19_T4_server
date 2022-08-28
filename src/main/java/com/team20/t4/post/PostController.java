package com.team20.t4.post;

import com.team20.t4.common.responseFormat.OnlyResponseString;
import com.team20.t4.member.MemberService;
import com.team20.t4.plan.PlanService;
import com.team20.t4.plan.domain.Location;
import com.team20.t4.plan.dto.ListAppointmentSimpleResponseDto;
import com.team20.t4.post.dto.LocationRequestDto;
import com.team20.t4.post.dto.PostResponseDto;
import com.team20.t4.post.dto.PostSaveRequestDto;
import com.team20.t4.post.dto.PostUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RequiredArgsConstructor
@RestController
public class PostController {
    private final MemberService memberService;
    private final PostService postService;
    private final PlanService planService;

    @PostMapping("/post/new")
    public Long saveNewPost(@RequestBody @Valid PostSaveRequestDto requestDto){
        return postService.savePost(requestDto);
    }

    @GetMapping("/post/location")
    public ListAppointmentSimpleResponseDto getPostListByLocation(@RequestBody LocationRequestDto location){
        Location gotLocation = location.getLocation();
        return postService.getPostListByLocation(gotLocation);
    }

    @GetMapping("/post/{postId}")
    public PostResponseDto getSinglePost(@PathVariable Long postId){
        return postService.getSinglePost(postId);
    }

    @PostMapping("/post/{postId}")
    public Long updatePost(@PathVariable Long postId, @RequestBody PostUpdateRequestDto requestDto){
        return postService.updatePost(postId, requestDto);
    }

    @DeleteMapping("/post/{postId}")
    public OnlyResponseString deletePost(@PathVariable Long postId){
        postService.deletePost(postId);
        return new OnlyResponseString("Post 삭제에 성공했습니다.");
    }

    @GetMapping("/member/posts")
    public ListAppointmentSimpleResponseDto getMyPostList(){
        return postService.getPostListWrittenByMe();
    }

}
