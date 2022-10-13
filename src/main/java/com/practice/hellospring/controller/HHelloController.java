package com.practice.hellospring.controller;

// 인텔리제이 자동완성 기능 지린다
// spring annotation 공부하기(https://melonicedlatte.com/2021/07/18/182600.html)
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

public class HHelloController {
//    /hello로 접속하면 이 메소드가 실행되고
    @GetMapping("hello")
//    Model이라는 객체는 변수를 담고 있음. 함수 생각하면 될 것 같음.
    public String hello(Model model) {
//        key-value 형식인건 ㅇㅋ, (스트링, 스트링)
        model.addAttribute("data", "hi!!");
//        리턴은 왜 해야 하는가? 리턴값
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
//        (스트링, name) key는 무조건 String? value는 Object?
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;

    }

    static class Hello {
        private String name;
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }
}
