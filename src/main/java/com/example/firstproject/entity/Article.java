package com.example.firstproject.entity;

import jakarta.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY) // DB가 id 자동 생성
    private Long id;
    @Column
    private String title;
    @Column
    private String content;

    public void patch(Article article) {
        if (article.title != null)
            this.title = article.title;
        if (article.content != null)
            this.content = article.content;
    }

    // 롬복을 이용해 Getter 추가

    // 기본 생성자 추가(롬복 @NoArgsConstructor 리팩터링)
    //Article() {

    //}
}
