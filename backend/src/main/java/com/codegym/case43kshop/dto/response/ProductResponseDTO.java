package com.codegym.case43kshop.dto.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ProductResponseDTO {
    private Long id;
    private String name;
    private int price;
    private String image;

}
