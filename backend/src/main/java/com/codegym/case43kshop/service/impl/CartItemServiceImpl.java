package com.codegym.case43kshop.service.impl;

import com.codegym.case43kshop.converter.CartItemConverter;
import com.codegym.case43kshop.dto.response.CartItemResponseDTO;
import com.codegym.case43kshop.entity.CartItem;
import com.codegym.case43kshop.entity.Product;
import com.codegym.case43kshop.entity.User;
import com.codegym.case43kshop.repository.CartItemRepository;
import com.codegym.case43kshop.repository.ProductRepository;
import com.codegym.case43kshop.security.JwtTokenUtil;
import com.codegym.case43kshop.service.CartItemService;
import com.codegym.case43kshop.service.ProductService;
import com.codegym.case43kshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CartItemServiceImpl implements CartItemService {
    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private ProductService productService;

    @Autowired
    private CartItemConverter cartItemConverter;

    @Autowired
    private ProductRepository productRepository;

//    @Autowired
//    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserService userService;

    @Override
    public CartItemResponseDTO addToCart(long productID, User user) throws Exception {
        User userTemp = userService.findByEmail(JwtTokenUtil.email);
        Product product = productService.findByID(productID);
        if (product == null){
            throw new Exception("Cannot save product");
        }
//        List<CartItem> cartItemList = new ArrayList<>();
//        product.setCartItemList(cartItemList);
        CartItem cartItem = new CartItem();
        cartItem.setQuantity(1);
        cartItem.setSubPrice(cartItem.getQuantity() * product.getPrice());
        cartItem.setCart(user.getCart());
        cartItem.setProduct(product);
        cartItemRepository.save(cartItem);
        CartItemResponseDTO cartItemResponseDTO = cartItemConverter.convertToResponseDTO(cartItem, product);
        return cartItemResponseDTO;
    }

    @Override
    public List<CartItemResponseDTO> getAllByCartID(long cartID) throws Exception {
        List<CartItem> cartItemList = cartItemRepository.findAllByCartId(cartID);
        if(cartItemList.isEmpty()){
            throw new Exception("Cart Items Not Found !!!");
        }
        List<CartItemResponseDTO> cartItemResponseDTOS = new ArrayList<>();
        for (CartItem cartItem : cartItemList){
            cartItemResponseDTOS.add(cartItemConverter.convertToResponseDTO(cartItem, cartItem.getProduct()));
        }
        return cartItemResponseDTOS;
    }

    @Override
    public CartItemResponseDTO update(long productID, int quantity, User user) throws Exception {
        Product product = productService.findByID(productID);
        List<CartItem> list = cartItemRepository.findAllByCartId(user.getCart().getId());
        CartItem cartItemTemp = new CartItem();
        for(CartItem cartItem : list){
            if (cartItem.getProduct().getId() == productID){
                cartItem.setQuantity(quantity);
                cartItemRepository.save(cartItem);
                cartItemTemp = cartItem;
            }
        }
        return cartItemConverter.convertToResponseDTO(cartItemTemp, product);
    }


}
