package com.study.jpa.chap01_basic.repository;

import com.study.jpa.chap01_basic.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
                                        // <Entity 클래스, Primary Key의 타입>


}
