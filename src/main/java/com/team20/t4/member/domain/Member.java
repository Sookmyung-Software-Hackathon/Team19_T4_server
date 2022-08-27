package com.team20.t4.member.domain;

import com.team20.t4.common.entity.BaseTimeEntity;
import com.team20.t4.post.domain.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Member extends BaseTimeEntity implements UserDetails {
    @Id @Column(name = "member_pk")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberPk;

    @Column(length = 20, nullable = false)
    private String memberId;

    @Column(length = 100, name = "member_password")
    private String password;

    @Column(length = 10, nullable = false, name = "member_name")
    private String name;

    @ElementCollection(fetch = FetchType.EAGER)
    @Builder.Default
    private List<String> roles = new ArrayList<>();

    @OneToOne(cascade = CascadeType.REMOVE, mappedBy = "member")
    private MemberProfileImg memberProfileImg;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "profile_id")
    private Profile profile;

    @OneToMany(mappedBy = "writer")
    List<Post> memberPosts = new ArrayList<>();

    @Builder
    public Member(String memberId, String password, String name, Profile profile){
        this.memberId = memberId;
        this.password = password;
        this.name = name;
        this.profile = profile;
    }

    // UserDetails //
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles
                .stream().map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public String getUsername() {
        return String.valueOf(this.memberPk);
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    // update //
    public Member updateName(String newName){
        this.name = newName;
        return this;
    }
}
