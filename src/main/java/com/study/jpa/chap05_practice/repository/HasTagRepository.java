package com.study.jpa.chap05_practice.repository;

import com.study.jpa.chap05_practice.entity.HashTag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HasTagRepository extends JpaRepository<HashTag, Long> {
}
