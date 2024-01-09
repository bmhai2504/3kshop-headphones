package com.codegym.case43kshop.converter;

import com.codegym.case43kshop.dto.response.CartItemResponseDTO;
import com.codegym.case43kshop.entity.CartItem;
import com.codegym.case43kshop.entity.Product;

public interface CartItemConverter {
    CartItemResponseDTO convertToResponseDTO(CartItem cartItem, Product product);
}
