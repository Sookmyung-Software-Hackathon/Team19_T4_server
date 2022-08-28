package com.team20.t4.plan.domain;

import com.team20.t4.member.domain.Member;
import com.team20.t4.plan.domain.RegisterHistory;
import com.team20.t4.post.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RegisterHistoryRepository extends JpaRepository<RegisterHistory, Long> {


    @Query("SELECT h FROM RegisterHistory h where h.applicant = :applicant and h.state = com.team20.t4.plan.domain.State.PERMITTED")
    List<RegisterHistory> readRegisterHistoriesByPermittedMember(@Param("applicant") Member applicant);

    @Query("select h from RegisterHistory h where h.plan =: plan")
    List<RegisterHistory> readRegisterHistoryByPlan(@Param("plan") Plan plan);

}
