package com.codegym.case43kshop.controller.non_authenticated;

import com.codegym.case43kshop.dto.common.CommonResponseListDTO;
import com.codegym.case43kshop.dto.common.CommonResponsePageDTO;
import com.codegym.case43kshop.dto.response.BrandResponseDTO;
import com.codegym.case43kshop.dto.response.CategoryResponseDTO;
import com.codegym.case43kshop.dto.response.MessageResponseDTO;
import com.codegym.case43kshop.dto.response.ProductResponseDTO;
import com.codegym.case43kshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
@CrossOrigin
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/recommendation")
    private ResponseEntity<?> getProductRecommend() {
        try {
            CommonResponseListDTO<ProductResponseDTO> response = productService.findProductRecomment();
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            String message = e.getMessage();
            MessageResponseDTO messageResponseDTO = new MessageResponseDTO(message);
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/all/sort")
    public ResponseEntity<?> getAllProduct(@PageableDefault(size = 15, page = 0)
                                            Pageable pageable,
                                           @RequestParam("order") String order, @RequestParam(name = "sort") String sort) {
        try {
            CommonResponsePageDTO<ProductResponseDTO> response = productService.getAllProduct(pageable, order, sort);
            System.out.println(pageable);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            String message = e.getMessage();
            MessageResponseDTO messageResponseDTO = new MessageResponseDTO(message);
            return new ResponseEntity<>(messageResponseDTO, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/all/thuancochap")
    public ResponseEntity<?> thuancohap(@PageableDefault(size = 15, page = 0,sort = "id")
                                           Pageable pageable
                                           ) {
        try {
            CommonResponsePageDTO<ProductResponseDTO> response = productService.thuancochap(pageable);
            System.out.println(pageable);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            String message = e.getMessage();
            MessageResponseDTO messageResponseDTO = new MessageResponseDTO(message);
            return new ResponseEntity<>(messageResponseDTO, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllProduct(@PageableDefault(size = 20, page = 0, sort = "id") Pageable pageable) {
        try {
            CommonResponsePageDTO<ProductResponseDTO> response = productService.getAllProduct(pageable);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            String message = e.getMessage();
            MessageResponseDTO messageResponseDTO = new MessageResponseDTO(message);
            return new ResponseEntity<>(messageResponseDTO, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam(name = "search") String search, @PageableDefault(size = 15, page = 0, sort = "id") Pageable pageable,
                                    @RequestParam("order") String order,
                                    @RequestParam("sort") String sort) {
        try {
            CommonResponsePageDTO<ProductResponseDTO> response = productService.search(pageable, order, sort, search);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            String message = e.getMessage();
            MessageResponseDTO messageResponseDTO = new MessageResponseDTO(message);
            return new ResponseEntity<>(messageResponseDTO, HttpStatus.NOT_FOUND);
        }
    }
}


