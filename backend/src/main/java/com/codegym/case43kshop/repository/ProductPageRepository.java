package com.codegym.case43kshop.repository;

import com.codegym.case43kshop.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductPageRepository extends PagingAndSortingRepository<Product, Long> {
    Page<Product> findAllByCategoryId(Pageable pageable, long categoryID);
}
