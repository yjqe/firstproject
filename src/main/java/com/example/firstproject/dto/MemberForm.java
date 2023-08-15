package com.example.firstproject.dto;

import com.example.firstproject.entity.Member;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class MemberForm {
    private Long id;
    private String email;
    private String password;

    // 생성자(롬복)
    // toString 오버라이드(롬복)

    public Member toEntity() { return new Member(id, email, password); }
}
