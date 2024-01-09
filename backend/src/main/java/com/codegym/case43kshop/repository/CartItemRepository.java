package com.codegym.case43kshop.repository;

import com.codegym.case43kshop.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    List<CartItem> findAllByCartId(long cartID);
}
