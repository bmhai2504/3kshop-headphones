package com.codegym.case43kshop.converter.impl;

import com.codegym.case43kshop.converter.UserConverter;
import com.codegym.case43kshop.dto.request.UserRequestDTO;
import com.codegym.case43kshop.dto.response.UserRegisterResponseDTO;
import com.codegym.case43kshop.dto.response.UserResponseDTO;
import com.codegym.case43kshop.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverterImpl implements UserConverter {
    @Override
    public User convertToEntity(UserRequestDTO userRequestDTO) {
        return User.builder()
                .email(userRequestDTO.getEmail())
                .name(userRequestDTO.getName())
                .password(userRequestDTO.getPassword())
                .build();
    }


    public UserRegisterResponseDTO convertToRegisterResponseDTO(User user) {
        return UserRegisterResponseDTO.builder()
                .email(user.getEmail())
                .name(user.getName())
                .message("Register Success !!!")
                .build();
    }

    @Override
    public UserResponseDTO convertToLoginResponseDTO(User user) {
        return UserResponseDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .token(user.getToken())
                .role(user.getRole().getName())
                .build();
    }
}
