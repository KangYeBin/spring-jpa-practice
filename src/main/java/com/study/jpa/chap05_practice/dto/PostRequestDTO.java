package com.study.jpa.chap05_practice.dto;

import com.study.jpa.chap05_practice.entity.Post;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostRequestDTO {

    // @NotNull : null을 허용하지 않음. "", " "은 허용
    // @NotEmpty : null, ""을 허용하지 않음, ""은 허용
    // @NotBlack : null, "", " " 모두 허용하지 않음

    @NotBlank
    @Size(min = 2, max = 5)
    private String writer;

    @NotBlank
    @Size(min = 1, max = 20)
    private String title;
    private String content;
    private List<String> hasTags;


    // dto를 entity로 변환하는 메서드
    public Post toEntity() {
        return Post.builder()
                .writer(writer)
                .title(title)
                .content(content)
                // 해시태그는 X
                .build();
    }
}
