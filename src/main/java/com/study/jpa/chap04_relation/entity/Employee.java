package com.study.jpa.chap04_relation.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
// JPA 연관관계 매핑에서 연관관계 데이터는 toString에서 제외해야 한다 (순환 참조 발생, 무한 루프 방지)
@ToString(exclude = {"department"})
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tbl_emp")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private Long id;

    @Column(name = "emp_name", nullable = false)
    private String name;

    // Employee와 Department는 N:1 관계이므로 ManyToOne
    // 외래 키를 가진 Employee는 Department 테이블의 갱신에 관여할 수 있다
    // LAZY : 필요한 경우에만 조인 수행
    // EAGER : 항상 무조건 조인 수행
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dept_id")
    private Department department;
}
