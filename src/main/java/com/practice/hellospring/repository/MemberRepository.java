package com.practice.hellospring.repository;

import com.practice.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

// Optional: 만약 null이면 Optional로 감싸서 null을 반환.
// 리포지토리에 4가지 기능을 만듦.
public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
