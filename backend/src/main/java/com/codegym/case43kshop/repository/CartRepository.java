package com.codegym.case43kshop.repository;

import com.codegym.case43kshop.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
