package com.practice.hellospring.repository;

import com.practice.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

//    실행되는 순서가 보장되지 않음. -> 순서랑 상관없이 모든 메소드가 따로 동작하도록 설계해야 함.
//    테스트 끝날 때마다 repository를 깨끗하게 지워줌.
//    AfterEach: 메소드 하나 끝날 때마다 실행
    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

//        new로 저장한 것과 DB에서 꺼낸 것이 똑같으면 참!
        Member result = repository.findById(member.getId()).get();
//        System.out.println("result = " + (result == member));

//        assertEquals(기대하는 값, 실제 값)
//        Assertions.assertEquals(member, result);
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

//        findByName으로 찾아서 result에 넣고 get()으로 옵션 한번 까서? 넣음
        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }

}