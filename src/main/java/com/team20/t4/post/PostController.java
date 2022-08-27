package com.team20.t4.post;

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

}
