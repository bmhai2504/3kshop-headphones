package com.codegym.case43kshop.dto.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserRequestDTO {
    private String email;
    private String name;
    private String password;
}
