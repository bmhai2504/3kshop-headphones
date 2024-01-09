package com.codegym.case43kshop.controller.non_authenticated;

import com.codegym.case43kshop.dto.common.CommonResponseListDTO;
import com.codegym.case43kshop.dto.common.CommonResponsePageDTO;
import com.codegym.case43kshop.dto.response.BrandResponseDTO;
import com.codegym.case43kshop.dto.response.MessageResponseDTO;
import com.codegym.case43kshop.dto.response.ProductResponseDTO;
import com.codegym.case43kshop.service.BrandService;
import com.codegym.case43kshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/brand")
@CrossOrigin
public class BrandController {
    @Autowired
    private BrandService brandService;

    @Autowired
    private ProductService productService;

    @GetMapping("/navbar")
    public ResponseEntity<?> getBrandsNavBar(@PageableDefault(size = 8) Pageable pageable){
        try {
            CommonResponsePageDTO<BrandResponseDTO> response = brandService.getBrandsNavBar(pageable);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            String message = e.getMessage();
            MessageResponseDTO messageResponseDTO = new MessageResponseDTO(message);
            return new ResponseEntity<>(messageResponseDTO, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllBrands(){
        try {
            CommonResponseListDTO<BrandResponseDTO> response = brandService.getAllBrands();
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            String message = e.getMessage();
            MessageResponseDTO messageResponseDTO = new MessageResponseDTO(message);
            return new ResponseEntity<>(messageResponseDTO, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{brandID}/products")
    public ResponseEntity<?> getProductsByBrandID(@PathVariable(name = "brandID") long id){
        try {
            CommonResponseListDTO<ProductResponseDTO> response = productService.getProductsByBrandID(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            String message = e.getMessage();
            MessageResponseDTO messageResponseDTO = new MessageResponseDTO(message);
            return new ResponseEntity<>(messageResponseDTO, HttpStatus.NOT_FOUND);
        }
    }

}
