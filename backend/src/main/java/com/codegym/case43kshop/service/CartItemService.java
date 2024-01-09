package com.codegym.case43kshop.service;

import com.codegym.case43kshop.dto.response.CartItemResponseDTO;
import com.codegym.case43kshop.entity.User;

import java.util.List;

public interface CartItemService {
    CartItemResponseDTO addToCart(long productID, User user) throws Exception;

    List<CartItemResponseDTO> getAllByCartID(long cartID) throws Exception;

    CartItemResponseDTO update(long productID, int quantity, User user) throws Exception;
}
