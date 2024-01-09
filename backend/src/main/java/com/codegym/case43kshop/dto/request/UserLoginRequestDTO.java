package com.codegym.case43kshop.dto.request;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserLoginRequestDTO {
    private String email;
    private String password;
}
