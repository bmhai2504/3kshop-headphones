package com.codegym.case43kshop.service.impl;

import com.codegym.case43kshop.converter.TypeConverter;
import com.codegym.case43kshop.dto.common.CommonResponseListDTO;
import com.codegym.case43kshop.dto.response.CategoryResponseDTO;
import com.codegym.case43kshop.dto.response.ProductResponseDTO;
import com.codegym.case43kshop.dto.response.TypeResponseDTO;
import com.codegym.case43kshop.entity.Category;
import com.codegym.case43kshop.entity.TypeProduct;
import com.codegym.case43kshop.repository.TypeRepository;
import com.codegym.case43kshop.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeRepository typeRepository;

    @Autowired
    private TypeConverter typeConverter;

    @Override
    public CommonResponseListDTO<TypeResponseDTO> findByCategoryID(long categoryID) throws Exception {
        List<TypeProduct> typeProducts = typeRepository.findAllByCategoryId(categoryID);
        if (typeProducts.isEmpty()){
            throw new Exception("Types Not Found!!!");
        }
        List<TypeResponseDTO> typeResponseDTOS = typeConverter.converterToResponseDTOs(typeProducts);
        CommonResponseListDTO<TypeResponseDTO> response = new CommonResponseListDTO<>();
        response.setTotalElements(typeProducts.size());
        response.setMessage("Get ALl Categories Success!!!");
        response.setSuccess(true);
        response.setData(typeResponseDTOS);
        return response;
    }
}
