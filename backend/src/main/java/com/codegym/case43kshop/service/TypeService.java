package com.codegym.case43kshop.service;

import com.codegym.case43kshop.dto.common.CommonResponseListDTO;
import com.codegym.case43kshop.dto.response.ProductResponseDTO;
import com.codegym.case43kshop.dto.response.TypeResponseDTO;

public interface TypeService {
    CommonResponseListDTO<TypeResponseDTO> findByCategoryID(long categoryID) throws Exception;
}
