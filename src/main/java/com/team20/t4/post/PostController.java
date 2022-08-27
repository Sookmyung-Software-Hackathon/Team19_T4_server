package com.team20.t4.post;

import com.team20.t4.common.responseFormat.OnlyResponseString;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
public class PostController {
    private final PostService postService;

    @PostMapping("/post/new")
    public Long saveNewPost(@RequestBody @Valid PostSaveRequestDto requestDto){
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

}
