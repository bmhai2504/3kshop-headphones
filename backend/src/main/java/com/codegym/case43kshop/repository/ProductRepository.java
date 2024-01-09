package com.codegym.case43kshop.repository;

import com.codegym.case43kshop.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByBrandId(Long brandID);

    Page<Product> findAllByNameLike(String search, Pageable pageable);
}
