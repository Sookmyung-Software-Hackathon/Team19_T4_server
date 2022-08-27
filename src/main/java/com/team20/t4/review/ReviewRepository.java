package com.team20.t4.review;

import com.team20.t4.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findAllByWriter(Member writer);
    List<Review> findAllByTarget(Member target);

    @Query(value = "SELECT AVG(r.score) from Review r WHERE r.target = ?1")
    Double calcMemberScore(Member target);
}
