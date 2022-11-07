package com.coco.board.application.dto;

import com.coco.board.domain.Posts;
import com.coco.board.domain.User;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * request, response DTO 클래스를 하나로 묶어 InnerStaticClass로 한 번에 관리
 */
public class PostsDto {


    /** 게시글의 등록과 수정을 처리할 요청(Request) 클래스 */
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Request {

        private Long id;
        private String title;
        private String writer;
        private String content;
        private String createdDate, modifiedDate;
        private int view;
        private User user;

        /* Dto -> Entity */
        public Posts toEntity() {
            Posts posts = Posts.builder()
                    .id(id)
                    .title(title)
                    .writer(writer)
                    .content(content)
                    .view(0)
                    .user(user)
                    .build();

            return posts;
        }
    }
