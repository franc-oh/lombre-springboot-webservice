package com.lombre.book.springboot.web.dto;

import com.lombre.book.springboot.domain.posts.Posts;
import javafx.geometry.Pos;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class PostsResponseDto {
    private Long id;
    private String title;
    private String content;
    private String author;


    public PostsResponseDto(Posts entity) {

        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }
}
