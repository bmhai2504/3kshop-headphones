package com.codegym.case43kshop.converter.impl;

import com.codegym.case43kshop.converter.TypeConverter;
import com.codegym.case43kshop.dto.response.TypeResponseDTO;
import com.codegym.case43kshop.entity.TypeProduct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TypeConverterImpl implements TypeConverter {
    @Override
    public TypeResponseDTO convertToResponseDTO(TypeProduct typeProduct) {
        return TypeResponseDTO.builder()
                .id(typeProduct.getId())
                .name(typeProduct.getName())
                .build();
    }

    @Override
    public List<TypeResponseDTO> converterToResponseDTOs(List<TypeProduct> typeProducts) {
        List<TypeResponseDTO> response = new ArrayList<>();
        for (TypeProduct typeProduct : typeProducts){
            response.add(convertToResponseDTO(typeProduct));
        }
        return response;
    }
}
