package com.codegym.case43kshop.service.impl;

import com.codegym.case43kshop.entity.Cart;
import com.codegym.case43kshop.entity.User;
import com.codegym.case43kshop.repository.CartRepository;
import com.codegym.case43kshop.service.CartService;
import com.codegym.case43kshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;



    @Override
    public Cart createNewCart() {
        Cart cart = new Cart();
        cartRepository.save(cart);
        return cart;
    }
}
