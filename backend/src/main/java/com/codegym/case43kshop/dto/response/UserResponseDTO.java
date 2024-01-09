package com.codegym.case43kshop.dto.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserResponseDTO {
    private long id;
    private String name;
    private String token;
    private String role;
}
