package com.codegym.case43kshop.converter.impl;

import com.codegym.case43kshop.converter.CartItemConverter;
import com.codegym.case43kshop.dto.response.CartItemResponseDTO;
import com.codegym.case43kshop.entity.CartItem;
import com.codegym.case43kshop.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class CartItemConverterImpl implements CartItemConverter {
    @Override
    public CartItemResponseDTO convertToResponseDTO(CartItem cartItem, Product product) {
        return CartItemResponseDTO.builder()
                .id(cartItem.getId())
                .productID(product.getId())
                .productName(product.getName())
                .price(product.getPrice())
                .quantity(cartItem.getQuantity())
                .subPrice(cartItem.getSubPrice())
//                .status(cartItem.isStatus())
                .build();
    }
}
