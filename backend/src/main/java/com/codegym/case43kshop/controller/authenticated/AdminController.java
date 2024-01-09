package com.codegym.case43kshop.controller.authenticated;

import com.codegym.case43kshop.dto.common.CommonResponsePageDTO;
import com.codegym.case43kshop.dto.response.MessageResponseDTO;
import com.codegym.case43kshop.dto.response.ProductResponseDTO;
import com.codegym.case43kshop.entity.Product;
import com.codegym.case43kshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin
public class AdminController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<?> getAllProduct(@PageableDefault(size = 2, page = 0,sort = "id") Pageable pageable){
        try {
            CommonResponsePageDTO<ProductResponseDTO> response = productService.getAllProduct(pageable);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            String message = e.getMessage();
            MessageResponseDTO messageResponseDTO = new MessageResponseDTO(message);
            return new ResponseEntity<>(messageResponseDTO, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/product/{productID}")
    public ResponseEntity<?> delete(@PathVariable long productID){
        productService.delete(productID);
        return new ResponseEntity<>("Delete success", HttpStatus.NO_CONTENT);
    }



}
