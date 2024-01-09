package com.codegym.case43kshop.converter;

import com.codegym.case43kshop.dto.request.UserRequestDTO;
import com.codegym.case43kshop.dto.response.UserRegisterResponseDTO;
import com.codegym.case43kshop.dto.response.UserResponseDTO;
import com.codegym.case43kshop.entity.User;

public interface UserConverter {
    User convertToEntity(UserRequestDTO userRequestDTO);

    UserRegisterResponseDTO convertToRegisterResponseDTO(User user);

    UserResponseDTO convertToLoginResponseDTO(User user);
}
