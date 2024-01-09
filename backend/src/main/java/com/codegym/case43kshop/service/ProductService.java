package com.codegym.case43kshop.service;

import com.codegym.case43kshop.dto.common.CommonResponseListDTO;
import com.codegym.case43kshop.dto.common.CommonResponsePageDTO;
import com.codegym.case43kshop.dto.response.BrandResponseDTO;
import com.codegym.case43kshop.dto.response.ProductResponseDTO;
import com.codegym.case43kshop.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    CommonResponsePageDTO<ProductResponseDTO> findByCategoryID(Pageable pageable, long categoryID) throws Exception;

    ProductResponseDTO findByProductID(Long productID);

    Product findByID(Long productID);

    CommonResponseListDTO<ProductResponseDTO> findProductRecomment() throws Exception;

    CommonResponsePageDTO<ProductResponseDTO> getAllProduct(Pageable pageable, String order, String sort) throws Exception;
    CommonResponsePageDTO<ProductResponseDTO> getAllProduct(Pageable pageable) throws Exception;
    CommonResponseListDTO<ProductResponseDTO> getProductsByBrandID(long id) throws Exception;

    Page<Product> getAllProducts(Pageable pageable) throws Exception;

    CommonResponsePageDTO<ProductResponseDTO> search(Pageable pageable, String order, String sort,String search) throws Exception;

    void delete(long productID);

    CommonResponsePageDTO<ProductResponseDTO> thuancochap(Pageable pageable) throws Exception;
}
