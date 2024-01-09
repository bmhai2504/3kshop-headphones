package com.codegym.case43kshop.service.impl;

import com.codegym.case43kshop.converter.BrandConverter;
import com.codegym.case43kshop.dto.common.CommonResponseListDTO;
import com.codegym.case43kshop.dto.common.CommonResponsePageDTO;
import com.codegym.case43kshop.dto.response.BrandResponseDTO;
import com.codegym.case43kshop.entity.Brand;
import com.codegym.case43kshop.repository.BrandPageRepository;
import com.codegym.case43kshop.repository.BrandRepository;
import com.codegym.case43kshop.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandPageRepository brandPageRepository;

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private BrandConverter brandConverter;

    @Override
    public CommonResponsePageDTO<BrandResponseDTO> getBrandsNavBar(Pageable pageable) throws Exception {
        Page<Brand> brandPage = brandPageRepository.findAll(pageable);
        if(brandPage.isEmpty()){
            throw new Exception("Brands For Index Page Not Found!!!");
        }
        CommonResponsePageDTO<BrandResponseDTO> response = new CommonResponsePageDTO<>();
        response.setPageNumber(brandPage.getNumber());
        response.setSize(brandPage.getSize());
        response.setTotalElements(brandPage.getTotalElements());
        response.setTotalPages(brandPage.getTotalPages());
        response.setSuccess(true);
        response.setMessage("Get Brands For Index Page Success!!!");
        response.setData(brandConverter.converterToResponseDTOs(brandPage.toList()));
        return response;
    }

    @Override
    public CommonResponseListDTO<BrandResponseDTO> getAllBrands() throws Exception {
        List<Brand> brandPage = brandRepository.findAll();
        if(brandPage.isEmpty()){
            throw new Exception("Brands For Index Page Not Found!!!");
        }
        CommonResponseListDTO<BrandResponseDTO> response = new CommonResponseListDTO<>();
        response.setTotalElements(brandPage.size());
        response.setSuccess(true);
        response.setMessage("Get All Brands Success!!!");
        response.setData(brandConverter.converterToResponseDTOs(brandPage));
        return response;
    }
}
