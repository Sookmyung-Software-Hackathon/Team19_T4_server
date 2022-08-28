package com.team20.t4.post.domain;

import com.team20.t4.member.domain.Member;
import com.team20.t4.post.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByWriter(Member loginedMember);
}
