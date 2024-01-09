package com.codegym.case43kshop.controller.authenticated;

import com.codegym.case43kshop.dto.request.UserLoginRequestDTO;
import com.codegym.case43kshop.dto.request.UserRequestDTO;
import com.codegym.case43kshop.dto.response.MessageResponseDTO;
import com.codegym.case43kshop.dto.response.UserRegisterResponseDTO;
import com.codegym.case43kshop.dto.response.UserResponseDTO;
import com.codegym.case43kshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthenticationController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserRequestDTO userRequestDTO) {
        try {
            UserRegisterResponseDTO response = userService.register(userRequestDTO);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }catch (Exception e) {
            String message = e.getMessage();
            MessageResponseDTO messageResponseDTO = new MessageResponseDTO(message);
            return new ResponseEntity<>(messageResponseDTO, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserLoginRequestDTO userLoginRequestDTO){
        try {
            UserResponseDTO response = userService.login(userLoginRequestDTO);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e) {
            String message = e.getMessage();
            MessageResponseDTO messageResponseDTO = new MessageResponseDTO(message);
            return new ResponseEntity<>(messageResponseDTO, HttpStatus.BAD_REQUEST);
        }

    }

}
