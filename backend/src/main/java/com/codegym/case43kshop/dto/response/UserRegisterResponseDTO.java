package com.codegym.case43kshop.dto.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserRegisterResponseDTO {
    private String email;
    private String name;
    private String message;
}
