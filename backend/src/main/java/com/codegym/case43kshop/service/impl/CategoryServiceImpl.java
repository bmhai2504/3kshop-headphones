package com.codegym.case43kshop.service.impl;

import com.codegym.case43kshop.converter.CategoryConverter;
import com.codegym.case43kshop.dto.common.CommonResponseListDTO;
import com.codegym.case43kshop.dto.response.CategoryResponseDTO;
import com.codegym.case43kshop.entity.Category;
import com.codegym.case43kshop.repository.CategoryRepository;
import com.codegym.case43kshop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryConverter categoryConverter;

    @Override
    public CommonResponseListDTO<CategoryResponseDTO> findAll() throws Exception {
        List<Category> categoryList = categoryRepository.findAll();
        if (categoryList.isEmpty()){
            throw new Exception("Category Not Found!!!");
        }
        List<CategoryResponseDTO> categoryResponseDTOList = categoryConverter.converterToResponseDTOs(categoryList);
        CommonResponseListDTO<CategoryResponseDTO> response = new CommonResponseListDTO<>();
        response.setTotalElements(categoryList.size());
        response.setMessage("Get ALl Categories Success!!!");
        response.setSuccess(true);
        response.setData(categoryResponseDTOList);
        return response;
    }
}
