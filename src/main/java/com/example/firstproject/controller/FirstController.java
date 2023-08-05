package com.example.firstproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; // Model 클래스 패키지 자동 임포트
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {

    @GetMapping("/hi")
    public String niceToMeetYou(Model model) {
        // model 객체가 "홍팍" 값을 "usename"에 연결해 웹 브라우저로 보냄
        model.addAttribute("username", "hongpark");
        return "greetings";
    }
}
