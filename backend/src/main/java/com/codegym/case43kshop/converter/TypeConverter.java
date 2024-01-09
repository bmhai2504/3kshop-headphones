package com.codegym.case43kshop.converter;

import com.codegym.case43kshop.dto.response.ProductResponseDTO;
import com.codegym.case43kshop.dto.response.TypeResponseDTO;
import com.codegym.case43kshop.entity.Product;
import com.codegym.case43kshop.entity.TypeProduct;

import java.util.List;

public interface TypeConverter {
    TypeResponseDTO convertToResponseDTO(TypeProduct typeProduct);

    List<TypeResponseDTO> converterToResponseDTOs(List<TypeProduct> typeProducts);

}
