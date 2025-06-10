package com.narendra.dtoandexception.repository;

import com.narendra.dtoandexception.entity.product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface productRepository extends JpaRepository<product,Integer> {
    // This class contain all methods of JPA.
}
