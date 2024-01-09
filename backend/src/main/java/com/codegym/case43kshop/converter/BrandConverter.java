package com.codegym.case43kshop.converter;

import com.codegym.case43kshop.dto.response.BrandResponseDTO;
import com.codegym.case43kshop.dto.response.CategoryResponseDTO;
import com.codegym.case43kshop.entity.Brand;
import com.codegym.case43kshop.entity.Category;

import java.util.List;

public interface BrandConverter {
    BrandResponseDTO convertToResponseDTO(Brand brand);

    List<BrandResponseDTO> converterToResponseDTOs(List<Brand> brandList);
}
