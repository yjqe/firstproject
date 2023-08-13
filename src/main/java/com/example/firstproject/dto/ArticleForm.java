package com.example.firstproject.dto;

import com.example.firstproject.entity.Article;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class ArticleForm {
    private Long id;
    private String title;
    private String content;
    // 전송받은 제목과 내용을 필드에 저장하는 생성자 추가(롬복 @AllArgsConstructor 리팩터링)

    //데이터를 잘 받았는지 확인할 toString() 메서드 추가(롬복 @ToString 리팩터링)

    public Article toEntity() {
        return new Article(id, title, content);
    }
}
