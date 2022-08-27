package com.team20.t4.post;

import com.team20.t4.common.entity.BaseTimeEntity;
import com.team20.t4.member.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Post extends BaseTimeEntity {
    @Id
    @Column(name = "post_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "post_title")
    private String title;

    @Column(name = "post_content", length = 1000)
    private String content;

    @Column(name = "post_chat_room_link")
    private String chatRoomLink;

    @OneToOne
    private Member writer;

//    @OneToOne - cascade persist
//    private Plan plan;

}
