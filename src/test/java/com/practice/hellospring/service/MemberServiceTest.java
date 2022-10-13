package com.practice.hellospring.service;

import com.jayway.jsonpath.internal.Utils;
import com.practice.hellospring.domain.Member;
import com.practice.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;


class MemberServiceTest {
//    MemberService memberService = new MemberService();
//    문제 발생: memberService에서 만든 MemoryMemberRepository와 여기서 new MemoryMemberRepository()가 다름!
//    MemoryMemberRepository memberRepository = new MemoryMemberRepository();

    MemberService memberService;
    MemoryMemberRepository memberRepository;

//    각 테스트를 실행할 때마다 그 전에 각각 memberRepository를 외부에서 MemberService에 넣어줌
//    -> Dependency Injection
    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void 회원가입() {
        // given
        Member member = new Member();
        member.setName("hello");

        // when
        Long saveId = memberService.join(member);
        
        // then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외() {
        // given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        // when
        memberService.join(member1);
//        try {
//            memberService.join(member2);
//            fail();
//        } catch (IllegalStateException e) {
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        }

//         IllegalStateException 에러가 터져야 해, memberService.join(member2) 이 로직을 태울 때
        assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        // then
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}