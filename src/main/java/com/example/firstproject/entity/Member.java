package com.example.firstproject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Getter
public class Member {
    // 생성자(롬복)
    // toString 메서드 오버라이딩(롬복)

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String email;
    @Column
    private String password;

    // Getter(롬복)
    // 기본 생성자

}
