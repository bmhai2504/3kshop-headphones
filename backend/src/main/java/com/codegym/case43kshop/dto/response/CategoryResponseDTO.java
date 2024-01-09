package com.codegym.case43kshop.dto.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CategoryResponseDTO {
    private Long id;
    private String name;
    private String image;
}
