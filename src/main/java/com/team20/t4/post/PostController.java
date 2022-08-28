package com.team20.t4.post;

import com.team20.t4.common.responseFormat.OnlyResponseString;
import com.team20.t4.member.MemberService;
import com.team20.t4.member.domain.Member;
import com.team20.t4.plan.PlanService;
import com.team20.t4.plan.dto.AppointmentSimpleResponseDto;
import com.team20.t4.post.dto.PostResponseDto;
import com.team20.t4.post.dto.PostSaveRequestDto;
import com.team20.t4.post.dto.PostUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostController {
    private final MemberService memberService;
    private final PostService postService;
    private final PlanService planService;

    @PostMapping("/post/new")
    public Long saveNewPost(@RequestBody @Valid PostSaveRequestDto requestDto){
//        Member loginedMember = memberService.getLoginedMember();
//        planService.createPlan(requestDto.getPlan(), loginedMember);
        return postService.savePost(requestDto);
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
    public List<AppointmentSimpleResponseDto> getMyPostList(){
        return postService.getPostListWrittenByMe();
    }

}
