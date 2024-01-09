package com.codegym.case43kshop.repository;

import com.codegym.case43kshop.entity.Brand;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BrandPageRepository extends PagingAndSortingRepository<Brand, Long> {
}
