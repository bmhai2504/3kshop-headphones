package com.codegym.case43kshop.service;

import com.codegym.case43kshop.dto.request.UserLoginRequestDTO;
import com.codegym.case43kshop.dto.request.UserRequestDTO;
import com.codegym.case43kshop.dto.response.UserRegisterResponseDTO;
import com.codegym.case43kshop.dto.response.UserResponseDTO;
import com.codegym.case43kshop.entity.User;

public interface UserService {
    UserRegisterResponseDTO register(UserRequestDTO userRequestDTO) throws Exception;

    User findByEmail(String email) throws Exception;

    UserResponseDTO login(UserLoginRequestDTO userLoginRequestDTO) throws Exception;
}
