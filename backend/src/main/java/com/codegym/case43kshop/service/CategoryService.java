package com.codegym.case43kshop.service;

import com.codegym.case43kshop.dto.common.CommonResponseListDTO;
import com.codegym.case43kshop.dto.response.CategoryResponseDTO;

public interface CategoryService {

    CommonResponseListDTO<CategoryResponseDTO> findAll() throws Exception;
}
