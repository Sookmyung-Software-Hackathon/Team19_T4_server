package com.team20.t4.post.dto;

import com.team20.t4.plan.dto.PlanInfoResponseDto;
import com.team20.t4.post.domain.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class PostResponseDto {

    private String title;
    private String content;
    private String chatRoomLink;
    private PlanInfoResponseDto planInfo;

    public static PostResponseDto of(Post post) {
        return PostResponseDto.builder()
                .title(post.getTitle())
                .content(post.getContent())
                .chatRoomLink(post.getChatRoomLink())
                .planInfo(PlanInfoResponseDto.of(post.getPlan()))
                .build();
    }
}
