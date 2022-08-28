package com.team20.t4.member;

import com.team20.t4.common.responseFormat.OnlyResponseString;
import com.team20.t4.member.dto.*;
import com.team20.t4.plan.domain.Plan;
import com.team20.t4.post.domain.Post;
import com.team20.t4.security.dto.TokenDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class MemberController {
    public final MemberService memberService;

    @PostMapping("/member/signup")
    public OnlyResponseString join(@RequestBody @Valid MemberSaveRequestDto requestDto){
        memberService.signup(requestDto);
        return new OnlyResponseString("회원가입에 성공했습니다.");
    }

    @PostMapping("/member/login")
    public TokenDto login(@RequestBody @Valid MemberLoginRequestDto requestDto){
        return memberService.login(requestDto);
    }

    @PostMapping("/member/reissue")
    public TokenDto reissue(@RequestBody @Valid TokenRequestDto requestDto){
        return memberService.reissue(requestDto);
    }

    @GetMapping("/member/info") // 이미지 url 추가
    public MemberInfoResponseDto getInfo(){
        return memberService.getMemberInfo();
    }

    @GetMapping("/member/info/other")
    public MemberInfoAndReviewListResponseDto getInfoAnotherMember(@RequestBody Map<String, String> memberId){
        return memberService.getMemberInfo(memberId.get("memberId"));
    }

    @GetMapping("/member/plans")
    public List<Plan> getMemberPlansList() {
        return memberService.getMemberPlansList();
    }


    @PostMapping("/member/info/profile")
    public OnlyResponseString updateMemberProfile(@RequestBody @Valid MemberProfileUpdateRequestDto requestDto){
        memberService.updateMemberProfile(requestDto);
        return new OnlyResponseString("회원 정보 수정에 성공했습니다.");
    }
    
    @PostMapping("/member/info/profile-image")
    public OnlyResponseString updateProfileImage(@RequestPart(value = "file") MultipartFile multipartFile){
        memberService.updateMemberProfileImg(multipartFile);
        return new OnlyResponseString("회원 프로필 이미지 수정에 성공했습니다.");
    }



}
