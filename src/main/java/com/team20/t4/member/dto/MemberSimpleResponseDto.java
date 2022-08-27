package com.team20.t4.member.dto;

import com.team20.t4.member.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class MemberSimpleResponseDto {
    private String memberId;
    private String name;

    public static MemberSimpleResponseDto of(Member member){
        return MemberSimpleResponseDto.builder()
                .memberId(member.getMemberId())
                .name(member.getName())
                .build();
    }
}
