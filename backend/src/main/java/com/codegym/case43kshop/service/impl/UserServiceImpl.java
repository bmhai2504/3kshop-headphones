package com.codegym.case43kshop.service.impl;

import com.codegym.case43kshop.converter.UserConverter;
import com.codegym.case43kshop.dto.request.UserLoginRequestDTO;
import com.codegym.case43kshop.dto.request.UserRequestDTO;
import com.codegym.case43kshop.dto.response.UserRegisterResponseDTO;
import com.codegym.case43kshop.dto.response.UserResponseDTO;
import com.codegym.case43kshop.entity.Cart;
import com.codegym.case43kshop.entity.Role;
import com.codegym.case43kshop.entity.User;
import com.codegym.case43kshop.repository.CartRepository;
import com.codegym.case43kshop.repository.RoleRepository;
import com.codegym.case43kshop.repository.UserRepository;
import com.codegym.case43kshop.security.JwtTokenUtil;
import com.codegym.case43kshop.service.CartService;
import com.codegym.case43kshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private CartService cartService;

    @Override
    public UserRegisterResponseDTO register(UserRequestDTO userRequestDTO) throws Exception {
        User user = userRepository.findByEmail(userRequestDTO.getEmail());

        if(user != null){
            throw new Exception("Email Already Exist !!!");
        }

        String hashPassword = passwordEncoder.encode(userRequestDTO.getPassword());
        userRequestDTO.setPassword(hashPassword);

        user = userConverter.convertToEntity(userRequestDTO);

        Role role = new Role(2l, "USER");
        user.setRole(role);

        Cart cart = cartService.createNewCart();
        user.setCart(cart);
        userRepository.save(user);


        UserRegisterResponseDTO userResponseDTO = userConverter.convertToRegisterResponseDTO(user);
        return userResponseDTO;
    }

    @Override
    public User findByEmail(String email) throws Exception {
        User user = userRepository.findByEmail(email);
        if(user == null){
            throw new Exception("User Not Found !!!");
        }
        return user;
    }

    @Override
    public UserResponseDTO login(UserLoginRequestDTO userLoginRequestDTO) throws Exception {
        User user = userRepository.findByEmail(userLoginRequestDTO.getEmail());
        if(user == null){
            throw new Exception("Email Wrong !!!");
        }
        if(passwordEncoder.matches(userLoginRequestDTO.getPassword(), user.getPassword())){
            String token = jwtTokenUtil.generateToken(user);
            user.setToken(token);
        }
        userRepository.save(user);
        UserResponseDTO userResponseDTO = userConverter.convertToLoginResponseDTO(user);
        return userResponseDTO;
    }
}
