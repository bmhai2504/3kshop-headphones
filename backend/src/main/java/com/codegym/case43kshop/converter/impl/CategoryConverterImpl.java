package com.codegym.case43kshop.converter.impl;

import com.codegym.case43kshop.converter.CategoryConverter;
import com.codegym.case43kshop.dto.response.CategoryResponseDTO;
import com.codegym.case43kshop.entity.Category;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryConverterImpl implements CategoryConverter {
    @Override
    public CategoryResponseDTO convertToResponseDTO(@NotNull Category category) {
        return CategoryResponseDTO.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }

    @Override
    public List<CategoryResponseDTO> converterToResponseDTOs(@NotNull List<Category> categoryList) {
        List<CategoryResponseDTO> categoryResponseDTOList = new ArrayList<>();
        for (Category category : categoryList){
            categoryResponseDTOList.add(convertToResponseDTO(category));
        }
        return categoryResponseDTOList;
    }


}
