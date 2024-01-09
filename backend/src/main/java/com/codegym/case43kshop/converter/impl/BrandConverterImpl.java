package com.codegym.case43kshop.converter.impl;

import com.codegym.case43kshop.converter.BrandConverter;
import com.codegym.case43kshop.dto.response.BrandResponseDTO;
import com.codegym.case43kshop.entity.Brand;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BrandConverterImpl implements BrandConverter {

    @Override
    public BrandResponseDTO convertToResponseDTO(Brand brand) {
        return BrandResponseDTO.builder()
                .id(brand.getId())
                .name(brand.getName())
                .image(brand.getImage())
                .build();
    }

    @Override
    public List<BrandResponseDTO> converterToResponseDTOs(List<Brand> brandList) {
        List<BrandResponseDTO> list = new ArrayList<>();
        for (Brand brand : brandList){
            list.add(convertToResponseDTO(brand));
        }
        return list;
    }
}
