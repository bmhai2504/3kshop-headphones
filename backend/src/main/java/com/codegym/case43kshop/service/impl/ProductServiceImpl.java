package com.codegym.case43kshop.service.impl;

import com.codegym.case43kshop.converter.ProductConverter;
import com.codegym.case43kshop.dto.common.CommonResponseListDTO;
import com.codegym.case43kshop.dto.common.CommonResponsePageDTO;
import com.codegym.case43kshop.dto.response.BrandResponseDTO;
import com.codegym.case43kshop.dto.response.CategoryResponseDTO;
import com.codegym.case43kshop.dto.response.ProductResponseDTO;
import com.codegym.case43kshop.entity.Brand;
import com.codegym.case43kshop.entity.Category;
import com.codegym.case43kshop.entity.Product;
import com.codegym.case43kshop.repository.ProductPageRepository;
import com.codegym.case43kshop.repository.ProductRepository;
import com.codegym.case43kshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductPageRepository productPageRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductConverter productConverter;

    @Override
    public CommonResponsePageDTO<ProductResponseDTO> findByCategoryID(Pageable pageable,long categoryID) throws Exception {
        Page<Product> productPage = productPageRepository.findAllByCategoryId(pageable, categoryID);

        if(productPage.isEmpty()){
            throw new Exception("Page Product Not Found!!!");
        }

        CommonResponsePageDTO<ProductResponseDTO> response = new CommonResponsePageDTO<>();
        response.setPageNumber(productPage.getNumber());
        response.setSize(productPage.getSize());
        response.setTotalElements(productPage.getTotalElements());
        response.setTotalPages(productPage.getTotalPages());
        response.setSuccess(true);
        response.setMessage("Get Brands For Index Page Success!!!");
        response.setData(productConverter.converterToResponseDTOs(productPage.toList()));
        return response;
    }

    @Override
    public CommonResponseListDTO<ProductResponseDTO> findProductRecomment() throws Exception {
        long totalProduct  = productPageRepository.count();
        if(totalProduct == 0){
            throw new Exception("Product Recommend Not Found!!!");
        }
        int[] randomArray = getRandomID((int)totalProduct);
        List<ProductResponseDTO> productResponseDTOS = new ArrayList<>();
        for (int index = 0; index < randomArray.length ; index++){
            productResponseDTOS.add(findByProductID( (long) randomArray[index] ));
        }
        CommonResponseListDTO<ProductResponseDTO> response = new CommonResponseListDTO<>();
        response.setTotalElements((long) productResponseDTOS.size());
        response.setSuccess(true);
        response.setMessage("Get Recommendation Products Success!!!");
        response.setData(productResponseDTOS);
        return response;

    }

    @Override
    public CommonResponsePageDTO<ProductResponseDTO> getAllProduct(Pageable pageable, String order, String sort) throws Exception {
        Sort sortPage;
        if ("asc".equals(order)){
            sortPage = Sort.by(Sort.Direction.ASC, sort);
        }else {
            sortPage = Sort.by(Sort.Direction.DESC, sort);
        }

        Page<Product> productPage = productPageRepository.findAll(PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), sortPage));

        if(productPage.isEmpty()){
            throw new Exception("Page Product Not Found!!!");
        }
        CommonResponsePageDTO<ProductResponseDTO> response = new CommonResponsePageDTO<>();
        response.setPageNumber(productPage.getNumber());
        response.setSize(productPage.getSize());
        response.setTotalElements(productPage.getTotalElements());
        response.setTotalPages(productPage.getTotalPages());
        response.setSuccess(true);
        response.setMessage("Get Brands For Index Page Success!!!");
        response.setData(productConverter.converterToResponseDTOs(productPage.toList()));
        return response;
    }

    @Override
    public CommonResponsePageDTO<ProductResponseDTO> getAllProduct(Pageable pageable) throws Exception {
        Page<Product> productPage = productPageRepository.findAll(pageable);

        if(productPage.isEmpty()){
            throw new Exception("Page Product Not Found!!!");
        }
        CommonResponsePageDTO<ProductResponseDTO> response = new CommonResponsePageDTO<>();
        response.setPageNumber(productPage.getNumber());
        response.setSize(productPage.getSize());
        response.setTotalElements(productPage.getTotalElements());
        response.setTotalPages(productPage.getTotalPages());
        response.setSuccess(true);
        response.setMessage("Get Brands For Index Page Success!!!");
        response.setData(productConverter.converterToResponseDTOs(productPage.toList()));
        return response;
    }

    @Override
    public CommonResponseListDTO<ProductResponseDTO> getProductsByBrandID(long id) throws Exception {
        List<Product> productList = productRepository.findAllByBrandId(id);
        if (productList.isEmpty()){
            throw new Exception("Category Not Found!!!");
        }
        List<ProductResponseDTO> productResponseDTOList = productConverter.converterToResponseDTOs(productList);
        CommonResponseListDTO<ProductResponseDTO> response = new CommonResponseListDTO<>();
        response.setTotalElements(productList.size());
        response.setMessage("Get ALl Categories Success!!!");
        response.setSuccess(true);
        response.setData(productResponseDTOList);
        return response;
    }

    @Override
    public Page<Product> getAllProducts(Pageable pageable) throws Exception {
        Page<Product> productPage = productPageRepository.findAll(pageable);
        if(productPage.isEmpty()){
            throw new Exception("Page Product Not Found!!!");
        }
        return productPage;
    }

    @Override
    public CommonResponsePageDTO<ProductResponseDTO> search(Pageable pageable, String order, String sort, String search) throws Exception {
        Sort sortPage;
        if ("asc".equals(order)){
            sortPage = Sort.by(Sort.Direction.ASC, sort);
        }else {
            sortPage = Sort.by(Sort.Direction.DESC, sort);
        }

        Page<Product> list = productRepository.findAllByNameLike("%" + search + "%", PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), sortPage));
        if (list.isEmpty()){
            throw new Exception("Products Not Found");
        }

        CommonResponsePageDTO<ProductResponseDTO> response = new CommonResponsePageDTO<>();
        response.setPageNumber(list.getNumber());
        response.setSize(list.getSize());
        response.setTotalElements(list.getTotalElements());
        response.setTotalPages(list.getTotalPages());
        response.setSuccess(true);
        response.setMessage("Get Brands For Index Page Success!!!");
        response.setData(productConverter.converterToResponseDTOs(list.toList()));
        return response;
    }

    @Override
    public void delete(long productID) {
        productRepository.deleteById(productID);
    }

    @Override
    public CommonResponsePageDTO<ProductResponseDTO> thuancochap(Pageable pageable) throws Exception {



        Page<Product> productPage = productPageRepository.findAll(pageable);

        if(productPage.isEmpty()){
            throw new Exception("Page Product Not Found!!!");
        }
        CommonResponsePageDTO<ProductResponseDTO> response = new CommonResponsePageDTO<>();
        response.setPageNumber(productPage.getNumber());
        response.setSize(productPage.getSize());
        response.setTotalElements(productPage.getTotalElements());
        response.setTotalPages(productPage.getTotalPages());
        response.setSuccess(true);
        response.setMessage("Get Brands For Index Page Success!!!");
        response.setData(productConverter.converterToResponseDTOs(productPage.toList()));
        return response;
    }

    @Override
    public ProductResponseDTO findByProductID(Long productID) {
        Product product = productPageRepository.findById(productID)
                .orElseThrow(
                        () -> new IllegalArgumentException(productID + "Is Illegal!!!")
                );
        ProductResponseDTO response = productConverter.convertToResponseDTO(product);
        return response;
    }

    @Override
    public Product findByID(Long productID) {
        Product product = productPageRepository.findById(productID)
                .orElseThrow(
                        () -> new IllegalArgumentException(productID + "Is Illegal!!!")
                );
        return product;
    }

    private int[] getRandomID(int total){
        int[] randomArray = new int[5];
        int count = 0;
        do {
            int number = (int)(Math.random() * (total + 1));
            if(isNumberIDExist(number, randomArray)){
                continue;
            }
            randomArray[count] = number;
            count++;
        }while(count < randomArray.length);
        return randomArray;
    }

    private boolean isNumberIDExist(int number, int[] array){
        for(int numberCheck : array){
            if (numberCheck == number){
                return true;
            }
        }
        return false;
    }
}
