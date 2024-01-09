package com.codegym.case43kshop.service;

import com.codegym.case43kshop.dto.common.CommonResponseListDTO;
import com.codegym.case43kshop.dto.common.CommonResponsePageDTO;
import com.codegym.case43kshop.dto.response.BrandResponseDTO;
import org.springframework.data.domain.Pageable;

public interface BrandService {
    CommonResponsePageDTO<BrandResponseDTO> getBrandsNavBar(Pageable pageable) throws Exception;

    CommonResponseListDTO<BrandResponseDTO> getAllBrands() throws Exception;
}
