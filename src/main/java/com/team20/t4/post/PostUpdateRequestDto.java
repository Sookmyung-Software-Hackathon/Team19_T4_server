package com.team20.t4.post;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostUpdateRequestDto {
    private Long postId;
    @Size(max = 255, message = "title은 255자 이하여야합니다.")
    private String title;
    @Size(max = 1000, message = "content는 1000자 이하여야합니다.")
    private String content;
    @Size(max = 255, message = "chatRoomLink는 255자 이하여야합니다.")
    private String chatRoomLink;
    //    private PlanSaveRequestDto plan;

    public Post toEntity(Long postId) {
        return Post.builder()
                .id(postId)
                .title(title)
                .content(content)
                .chatRoomLink(chatRoomLink)
                .build();
    }
}
