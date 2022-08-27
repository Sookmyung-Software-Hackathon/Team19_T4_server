package com.team20.t4.member.dto;

import com.team20.t4.member.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Collections;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemberSaveRequestDto {
    @NotEmpty(message = "아이디는 빈값일 수 없습니다.")
    private String memberId;
    @NotEmpty(message = "비밀번호는 빈값일 수 없습니다.")
    private String password;
    @NotBlank(message = "이름은 빈 값일 수 없습니다.")
    private String name;

    @NotNull(message = "프로필은 null값일 수 없습니다.")
    private ProfileSaveRequestDto profileDto;

    public Member toEntityWithEncodedPassword(PasswordEncoder passwordEncoder){
        return Member.builder()
                .memberId(memberId)
                .password(passwordEncoder.encode(password))
                .name(name)
                .profile(profileDto.toEntity())
                .roles(Collections.singletonList("ROLE_USER"))
                .build();
    }
}
