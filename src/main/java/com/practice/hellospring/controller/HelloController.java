package com.practice.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

//    스프링이 web application에서 '/hello'로 들어오면 이 메소드를 호출해줌
    @GetMapping("hello")
    public String hello(Model model) {
//        key: 'data', value: 'hello!'
        model.addAttribute("data", "hello!^!^~~~~~~!!!!!");
        return "hello";
    }

    @GetMapping("hello-mvc")
//    @RequestParam: 외부에서 파라미터를 받음
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

//    ResponseBody: HTTP의 body부분의 데이터를 직접 넣어주겠다!
    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name) {
        return "hello" + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
//    Hello라는 객체를 먼저 만들고
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;

//        getter && setter: 프로퍼티 접근 방식
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
