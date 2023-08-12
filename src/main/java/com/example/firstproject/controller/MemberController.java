package com.example.firstproject.controller;

import com.example.firstproject.dto.MemberForm;
import com.example.firstproject.entity.Member;
import com.example.firstproject.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Slf4j
@Controller
public class MemberController {
    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/members/new")
    public String newMemberForm() { return "members/new"; }

    @PostMapping("/members/create")
    public String createMember(MemberForm form) {
        // DTO에 폼 데이터가 잘 담겼는지 확인
        log.info(form.toString());

        // 1. DTO를 엔티티로 변환
        Member member = form.toEntity();
        log.info(member.toString());

        // 2. 엔티티를 DB에 저장(리파지터리)
        Member saved = memberRepository.save(member);
        log.info(saved.toString());

        return "redirect:/members/" + saved.getId();
    }

    @GetMapping("/members/{id}")
    public String show(@PathVariable Long id, Model model) {
        log.info("id = " + id);

        // 1. id를 조회해 데이터 가져오기
        Member memberEntity = memberRepository.findById(id).orElse(null);

        // 2. 모델에 데이터 등록하기
        model.addAttribute("member", memberEntity);

        // 3. 뷰 페이지 반환하기
        return "members/show";
    }

    @GetMapping("/members")
    public String index(Model model) {
        // 1. 모든 데이터 가져오기
        List<Member> memberEntityList = memberRepository.findAll();

        // 2. 가져온 Member 묶음을 모델에 등록하기
        model.addAttribute("memberList", memberEntityList);

        // 3. 사용자에게 보여줄 뷰 페이지 설정하기
        return "members/index";
    }
}

































