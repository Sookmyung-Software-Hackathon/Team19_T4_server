package com.team20.t4.plan;

import com.team20.t4.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RegisterHistoryRepository extends JpaRepository<RegisterHistory, Long> {

    @Query("SELECT h FROM RegisterHistory h where h.applicant = :applicant and h.state = com.team20.t4.plan.State.PERMITTED")
    List<RegisterHistory> readRegisterHistoriesByMember(@Param("applicant") Member applicant);
}
