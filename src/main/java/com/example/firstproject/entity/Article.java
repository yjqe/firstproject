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
public class Article {
    // Article 생성자 추가(롬복 @AllArgsConstructor 리팩터링)

    // toString 메서드 추가(롬복 @ToString 리팩터링)

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String title;
    @Column
    private String content;

    // 롬복을 이용해 Getter 추가

    // 기본 생성자 추가(롬복 @NoArgsConstructor 리팩터링)
    //Article() {

    //}
}
