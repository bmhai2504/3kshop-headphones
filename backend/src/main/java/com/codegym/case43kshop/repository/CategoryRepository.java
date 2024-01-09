package com.codegym.case43kshop.repository;

import com.codegym.case43kshop.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
