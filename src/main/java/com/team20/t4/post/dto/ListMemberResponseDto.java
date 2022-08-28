package com.team20.t4.post.dto;

import com.team20.t4.member.domain.Member;
import com.team20.t4.member.dto.ApplicantInfoDto;
import com.team20.t4.member.dto.MemberSimpleResponseDto;
import com.team20.t4.plan.dto.UpdateStateDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
public class ListMemberResponseDto {

    private List<ApplicantInfoDto> applicants = new ArrayList<>();
}
