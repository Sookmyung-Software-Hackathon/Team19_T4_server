package com.team20.t4.post;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostSaveRequestDto {
    private String title;
    private String content;
    private String chatRoomLink;
//    private PlanSaveRequestDto plan;
}
