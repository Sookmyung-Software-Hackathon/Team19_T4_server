package com.team20.t4.member.dto;


import com.team20.t4.member.domain.Member;
import com.team20.t4.plan.domain.RegisterHistory;
import com.team20.t4.plan.dto.UpdateStateDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class ApplicantInfoDto {

    private Long applicantId;
    private String name;
    private UpdateStateDto stateDto;

    public static ApplicantInfoDto toDto(MemberInfoResponseDto dto, RegisterHistory history){
        Member applicant = history.getApplicant();
        return ApplicantInfoDto.builder()
                .name(dto.getName())
                .stateDto(UpdateStateDto.of(history.getState()))
                .build();
    }
}
