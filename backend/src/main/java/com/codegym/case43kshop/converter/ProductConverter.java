package com.codegym.case43kshop.converter;

import com.codegym.case43kshop.dto.response.BrandResponseDTO;
import com.codegym.case43kshop.dto.response.ProductResponseDTO;
import com.codegym.case43kshop.entity.Brand;
import com.codegym.case43kshop.entity.Product;

import java.util.List;

public interface ProductConverter {
    ProductResponseDTO convertToResponseDTO(Product product);

    List<ProductResponseDTO> converterToResponseDTOs(List<Product> productList);

}
