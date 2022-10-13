package com.practice.hellospring.repository;

import com.practice.hellospring.domain.Member;

import java.util.*;

// 이게 구현체
public class MemoryMemberRepository implements MemberRepository {

//    static으로 선언했기 때문에 당장 문제가 발생하지는 않음. 없으면 다른 디비로 들어가니까 문제.
    private static Map<Long, Member> store = new HashMap<>();
//    key값을 생성해줌(0,1,2,,,)
//    원래 실무에서는 동시성 문제를 고려해서 AtomicLong으로 해야함
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream() // 루프를 돌면서
                .filter(member -> member.getName().equals(name)) // 필터링해서
                .findAny(); //찾아서 리턴
//        만약 없으면 Optional에 null이 포함되어서 리턴
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }

}

// 검증하기: 테스트 케이스 작성하기



