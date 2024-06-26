package com.study.jpa.chap05_practice.dto;

import com.study.jpa.chap05_practice.entity.Post;
import lombok.*;
import org.springframework.data.domain.Page;

@Getter
@Setter
@ToString
public class PageResponseDTO {

    private int startPage;
    private int endPage;
    private int currentPage;
    private boolean prev, next;
    private int totalCount;
    // 한 페이지에 배치할 페이지 버튼 수 (1~10 // 11~20)
    private static final int PAGE_COUNT = 10;

    public PageResponseDTO(Page<Post> pageData) {
        // 기존에 사용했던 PageCreator와 동일
        // 매개값으로 전달된 Page 객체가 기존보다 많은 정보를 제공하므로 더 간단
        this.totalCount = (int) pageData.getTotalElements();
        this.currentPage = pageData.getPageable().getPageNumber() + 1;
        this.endPage = (int) (Math.ceil((double) currentPage / PAGE_COUNT) * PAGE_COUNT);
        this.startPage = endPage - PAGE_COUNT + 1;

        int realEnd = pageData.getTotalPages();
        if (realEnd < this.endPage) this.endPage = realEnd;

        this.prev = startPage > 1;
        this.next = endPage < realEnd;
    }
}
