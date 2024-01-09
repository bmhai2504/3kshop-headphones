package com.codegym.case43kshop.converter;

import com.codegym.case43kshop.dto.response.CategoryResponseDTO;
import com.codegym.case43kshop.entity.Category;

import java.util.List;

public interface CategoryConverter {
    CategoryResponseDTO convertToResponseDTO(Category category);

    List<CategoryResponseDTO> converterToResponseDTOs(List<Category> categoryList);
}
