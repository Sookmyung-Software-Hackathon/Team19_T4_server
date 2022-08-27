package com.team20.t4.post.dto;

import com.team20.t4.member.domain.Member;
import com.team20.t4.post.domain.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostSaveRequestVo {
    private String title;
    private String content;
    private String chatRoomLink;
    private Member writer;
//    private Plan plan;

    public static PostSaveRequestVo of(PostSaveRequestDto requestDto){
        return PostSaveRequestVo.builder()
                .title(requestDto.getTitle())
                .content(requestDto.getContent())
                .chatRoomLink(requestDto.getChatRoomLink())
                .build();
    }

    public void updateWriter(Member writer){
        this.writer = writer;
    }

    public Post toEntity() {
        return Post.builder()
                .title(title)
                .content(content)
                .chatRoomLink(chatRoomLink)
                .writer(writer)
                .build();
    }
}
