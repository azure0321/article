package com.example.demo.repository;

import org.springframework.stereotype.Repository;
import com.example.demo.model.Member;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface MemberRepository extends JpaRepository<Member,String>{
    // "select * from member where member_id = 'memberId' and member_pw = 'memberPw'"
    Member findByMemberIdAndMemberPw(String memberId, String memberPw);
    List<Member> findByMemberPwAndMemberId(String memberPw, String memberId);
    List<Member> findByMemberId(String memberId);
}