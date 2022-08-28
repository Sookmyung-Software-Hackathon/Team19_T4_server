package com.team20.t4.plan.domain;

import com.team20.t4.member.domain.Member;
import com.team20.t4.plan.domain.RegisterHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RegisterHistoryRepository extends JpaRepository<RegisterHistory, Long> {


    @Query("SELECT h FROM RegisterHistory h where h.applicant = :applicant and h.state = com.team20.t4.plan.domain.State.PERMITTED")
    List<RegisterHistory> readRegisterHistoriesByPermittedMember(@Param("applicant") Member applicant);

    // Plan.progress != COMPLETED_PLAN 이고 State.PERMITTED인 회원의 RegisterHistory
    @Query("SELECT h FROM RegisterHistory h where h.applicant = :applicant and h.state = com.team20.t4.plan.domain.State.PERMITTED and h.plan.progress != com.team20.t4.plan.domain.Progress.COMPLETED_PLAN")
    List<RegisterHistory> readRegisterHistoriesByPermittedMemberAndOnProcess(@Param("applicant") Member applicant);


}
