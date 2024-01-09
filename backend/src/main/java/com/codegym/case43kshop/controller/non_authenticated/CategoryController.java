package com.codegym.case43kshop.controller.non_authenticated;

import com.codegym.case43kshop.dto.common.CommonResponseListDTO;
import com.codegym.case43kshop.dto.common.CommonResponsePageDTO;
import com.codegym.case43kshop.dto.response.CategoryResponseDTO;
import com.codegym.case43kshop.dto.response.MessageResponseDTO;
import com.codegym.case43kshop.dto.response.ProductResponseDTO;
import com.codegym.case43kshop.dto.response.TypeResponseDTO;
import com.codegym.case43kshop.service.CategoryService;
import com.codegym.case43kshop.service.ProductService;
import com.codegym.case43kshop.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/category")
@CrossOrigin
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @Autowired
    private TypeService typeService;

    @GetMapping("")
    public ResponseEntity<?> findAllCategories(){
        try {
            CommonResponseListDTO<CategoryResponseDTO> response= categoryService.findAll();
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            String message = e.getMessage();
            MessageResponseDTO messageResponseDTO = new MessageResponseDTO(message);
            return new ResponseEntity<>(messageResponseDTO, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{categoryID}/products")
    public ResponseEntity<?> findProductsByCategoryID(@PathVariable(name = "categoryID") long categoryID,
                                                      @PageableDefault(size = 14)Pageable pageable){
        try {
            CommonResponsePageDTO<ProductResponseDTO> response = productService.findByCategoryID(pageable, categoryID);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            String message = e.getMessage();
            MessageResponseDTO messageResponseDTO = new MessageResponseDTO(message);
            return new ResponseEntity<>(messageResponseDTO, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{categoryID}/types")
    public ResponseEntity<?> findTypeByCategoryID(@PathVariable(name = "categoryID") long categoryID){
        try {
            CommonResponseListDTO<TypeResponseDTO> response = typeService.findByCategoryID(categoryID);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            String message = e.getMessage();
            MessageResponseDTO messageResponseDTO = new MessageResponseDTO(message);
            return new ResponseEntity<>(messageResponseDTO, HttpStatus.NOT_FOUND);
        }
    }


}
