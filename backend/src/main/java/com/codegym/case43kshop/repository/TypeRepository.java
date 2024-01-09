package com.codegym.case43kshop.repository;

import com.codegym.case43kshop.entity.TypeProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TypeRepository extends JpaRepository<TypeProduct, Long> {
    List<TypeProduct> findAllByCategoryId(long categoryID);
}
