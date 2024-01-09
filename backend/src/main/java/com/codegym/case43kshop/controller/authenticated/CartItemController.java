package com.codegym.case43kshop.controller.authenticated;

import com.codegym.case43kshop.dto.response.CartItemResponseDTO;
import com.codegym.case43kshop.dto.response.MessageResponseDTO;
import com.codegym.case43kshop.entity.CartItem;
import com.codegym.case43kshop.entity.User;
import com.codegym.case43kshop.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/cart-item")
@CrossOrigin
public class CartItemController {
    @Autowired
    private CartItemService cartItemService;

    @PutMapping("/product/{productID}")
    public ResponseEntity<?> addToCart(@PathVariable(name = "productID") long productID, HttpServletRequest request) throws Exception {
        try {
            User user = (User) request.getAttribute("user");
            CartItemResponseDTO cartItemResponseDTO = cartItemService.addToCart(productID, user);
            return new ResponseEntity<>(cartItemResponseDTO, HttpStatus.OK);
        }catch (Exception e){
            String message = e.getMessage();
            MessageResponseDTO messageResponseDTO = new MessageResponseDTO(message);
            return new ResponseEntity<>(messageResponseDTO, HttpStatus.NOT_FOUND);
        }


    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllCartItem(HttpServletRequest request){
        try {
            User user = (User) request.getAttribute("user");
            List<CartItemResponseDTO> response = cartItemService.getAllByCartID(user.getCart().getId());
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            String message = e.getMessage();
            MessageResponseDTO messageResponseDTO = new MessageResponseDTO(message);
            return new ResponseEntity<>(messageResponseDTO, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{productID}")
    public ResponseEntity<?> update(@RequestParam int quantity, HttpServletRequest request, @PathVariable long productID){
        try {
            User user = (User) request.getAttribute("user");
            CartItemResponseDTO cartItemResponseDTO = cartItemService.update(productID, quantity, user);
            return new ResponseEntity<>(cartItemResponseDTO, HttpStatus.OK);
        }catch (Exception e){
            String message = e.getMessage();
            MessageResponseDTO messageResponseDTO = new MessageResponseDTO(message);
            return new ResponseEntity<>(messageResponseDTO, HttpStatus.NOT_FOUND);
        }
    }



}
