package com.codegym.case43kshop.converter.impl;

import com.codegym.case43kshop.converter.ProductConverter;
import com.codegym.case43kshop.dto.response.BrandResponseDTO;
import com.codegym.case43kshop.dto.response.ProductResponseDTO;
import com.codegym.case43kshop.entity.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductConverterImpl implements ProductConverter {
    @Override
    public ProductResponseDTO convertToResponseDTO(Product product) {
        return ProductResponseDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .image(product.getImage())
                .build();
    }

    @Override
    public List<ProductResponseDTO> converterToResponseDTOs(List<Product> productList) {
        List<ProductResponseDTO> list = new ArrayList<>();
        for (Product product : productList){
            list.add(convertToResponseDTO(product));
        }
        return list;
    }
}
