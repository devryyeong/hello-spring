package com.practice.hellospring.controller;

import com.practice.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
    private final MemberService memberService;

//    helloController가 스프링이 뜰 때 스프링 컨테이너에 등록됨
//    생성자 호출?
//    스프링이
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
